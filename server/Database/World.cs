using System;
using System.ComponentModel.DataAnnotations;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class World {
        [Key]
        public ulong Id {
            get;
            set;
        }

        public DateTime StartTime {
            get;
            set;
        }
    }
}
