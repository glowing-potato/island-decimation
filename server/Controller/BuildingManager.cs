using System;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Database;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Model;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Controller {
    public class BuildingManager {
        Island Island;

        public Building Build(BuildingType type, double x, double y) {
            Building building = new Building {
                Type = type,
                X = x,
                Y = y,
                Level = 1
            };
            DatabaseContext.Instance.Buildings.Add(building);
            UpgradeLog log = new UpgradeLog {
                Island = Island,
                Building = building,
                Time = DateTime.Now,
                Level = 1
            };
            DatabaseContext.Instance.UpgradeLogs.Add(log);
            return building;
        }

        public BuildingManager(Island island) {
            Island = island;
        }
    }
}
