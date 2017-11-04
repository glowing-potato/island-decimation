using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Database;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Controller {
    public class WorldBattleManager {
        const int UsersPerBattle = 2;
        public readonly World World;
        public List<BattleManager> Battles;
        ConcurrentBag<User> QueuedUsers;

        public void QueueUser(User user) {
            if (user.Islands.Count != 1) {
                throw new InvalidOperationException("Player can only battle using a single island");
            }
            QueuedUsers.Add(user);
            if (QueuedUsers.Count > UsersPerBattle) {
                ConcurrentBag<User> old = QueuedUsers;
                QueuedUsers = new ConcurrentBag<User>();
                Battles.Add(new BattleManager(this, old.ToArray()));
            }
        }

        public WorldBattleManager(World world) {
            World = world;
            Battles = new List<BattleManager>();
            QueuedUsers = new ConcurrentBag<User>();
        }
    }
}
