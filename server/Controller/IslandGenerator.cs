using System;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.View;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Database;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Controller {
    public static class IslandGenerator {
        public static Terrain Generate(double x, double y) {
            Console.Error.WriteLine("Not implemented: C.G.G.I.S.C.IslandGenerator");
            return new Terrain();
        }

        public static Database.Island GenerateValidIsland(User user) {
            double x, y;
            Terrain terrain;
            Random random = new Random();
            do {
                x = random.NextDouble();
                y = random.NextDouble();
                terrain = Generate(x, y);
            } while (!IslandValidator.Validate(terrain));
            return new Database.Island {
                User = user,
                FractalX = x,
                FractalY = y
            }
        }
    }
}
