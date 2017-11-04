using System;
using System.Threading;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Database;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.View;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Controller {
    public class BattleManager {
        WorldBattleManager World;
        User[] Users;

        void Simulate() {
            foreach (User user in Users) {
                World.Network.ConnectedUsers[user].Model.State = ViewState.BattleView;
            }
            // TODO
            foreach (User user in Users) {
                World.Network.ConnectedUsers[user].Model.State = ViewState.BuildView;
            }
        }

        public BattleManager(WorldBattleManager world, User[] users) {
            World = world;
            Users = users;
            Thread thread = new Thread(Simulate);
            thread.Start();
        }
    }
}
