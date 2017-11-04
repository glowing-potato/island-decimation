using System;
using System.Linq;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Database;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Model;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Controller {
    public class UserCreator {
        const int MaxPlayersPerWorld = 1000;
        const int StartingWood = 100;
        const int StartingWheat = 50;
        const int StartingIridium = 10;
        const int IslandChoices = 10;

        public static void CreateUser(User user) {
            World world = DatabaseContext.Instance.Worlds.OrderByDescending(w => w.StartTime).FirstOrDefault();
            if (world == null || world.Users.Count >= MaxPlayersPerWorld) {
                world = new World {
                    StartTime = DateTime.Now
                };
                DatabaseContext.Instance.Worlds.Add(world);
            }
            user.World = world;
            DatabaseContext.Instance.Users.Add(user);
            for (int i = 0; i < IslandChoices; ++i) {
                byte[] terrain = new byte[8];
                new Random().NextBytes(terrain);
                Island island = new Island {
                    User = user,
                    Terrain = BitConverter.ToInt64(terrain, 0),
                    Wood = StartingWood,
                    Wheat = StartingWheat,
                    Iridium = StartingIridium
                };
                DatabaseContext.Instance.Islands.Add(island);
                BuildingManager buildings = new BuildingManager(island);
                buildings.Build(BuildingType.Castle, 0, 0);
            }
        }
    }
}
