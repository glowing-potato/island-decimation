using System;
using System.Threading;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Database;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Controller {
    public class BattleManager {
        WorldBattleManager World;
        User[] Users;

        void Simulate() {
            
        }

        public BattleManager(WorldBattleManager world, User[] users) {
            World = world;
            Users = users;
            Thread thread = new Thread(Simulate);
            thread.Start();
        }
    }
}
