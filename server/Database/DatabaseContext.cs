using System;
using System.Data.Entity;
using System.Timers;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class DatabaseContext : DbContext {
        const double AutoSaveInterval = 1000;
        public static readonly DatabaseContext Instance = new DatabaseContext();
        Timer Timer;

        public virtual DbSet<User> Users {
            get;
            set;
        }

        void AutoSave(object sender, ElapsedEventArgs e) {
            SaveChanges();
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
