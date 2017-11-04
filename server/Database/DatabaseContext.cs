using System;
using System.Data.Entity;
using System.Timers;
using System.Linq;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class DatabaseContext : DbContext {
        const double AutoSaveInterval = 1000;
        public static readonly DatabaseContext Instance = new DatabaseContext();
        Timer Timer;

        public virtual DbSet<Battle> Battles {
            get;
            set;
        }

        public virtual DbSet<BattleIsland> BattleIslands {
            get;
            set;
        }

        public virtual DbSet<BattlePlaceLog> BattlePlaceLogs {
            get;
            set;
        }

        public virtual DbSet<BattleTargetLog> BattleTargetLogs {
            get;
            set;
        }

        public virtual DbSet<Building> Buildings {
            get;
            set;
        }

        public virtual DbSet<Island> Islands {
            get;
            set;
        }

        public virtual DbSet<UpgradeLog> UpgradeLogs {
            get;
            set;
        }

        public virtual DbSet<User> Users {
            get;
            set;
        }

        public virtual DbSet<World> Worlds {
            get;
            set;
        }

        void AutoSave(object sender, ElapsedEventArgs e) {
            SaveChanges();
        }

        public void Load() {
            Worlds.ToArray();
        }

        DatabaseContext() {
            Database.CreateIfNotExists();
            Timer = new Timer {
                AutoReset = true,
                Interval = AutoSaveInterval
            };
            Timer.Elapsed += AutoSave;
            Timer.Start();
        }
    }
}
