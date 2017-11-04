using System;
using System.Data.Entity;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class DatabaseContext : DbContext {
        public virtual DbSet<Battle> Battles {
            get;
            set;
        }

        public virtual DbSet<BattleIsland> BattleIslands {
            get;
            set;
        }

        public virtual DbSet<BattlePlaceLog> BattlePlaceLog {
            get;
            set;
        }

        public virtual DbSet<BattleTargetLog> BattleTargetLog {
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

        public virtual DbSet<UpgradeLog> UpgradeLog {
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
    }
}
