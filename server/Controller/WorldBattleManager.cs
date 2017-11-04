using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Database;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Network;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.View;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Controller {
    public class WorldBattleManager {
        const int UsersPerBattle = 2;
        public readonly World World;
        public readonly NetworkServer Network;
        public List<BattleManager> Battles;
        ConcurrentBag<User> QueuedUsers;

        public void QueueUser(User user) {
            if (user.Islands.Count != 1) {
                throw new InvalidOperationException("Player can only battle using a single island");
            }
            Network.ConnectedUsers[user].Model.State = ViewState.QueueingForBattle;
            QueuedUsers.Add(user);
            if (QueuedUsers.Count > UsersPerBattle) {
                ConcurrentBag<User> old = QueuedUsers;
                QueuedUsers = new ConcurrentBag<User>();
                Battles.Add(new BattleManager(this, old.ToArray()));
            }
        }

        public WorldBattleManager(World world, NetworkServer network) {
            World = world;
            Network = network;
            Battles = new List<BattleManager>();
            QueuedUsers = new ConcurrentBag<User>();
        }
    }
}
