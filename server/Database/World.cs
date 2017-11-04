using System;
using System.ComponentModel.DataAnnotations;
using System.Collections.Generic;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class World {
        [Key]
        public long Id {
            get;
            set;
        }

        public DateTime StartTime {
            get;
            set;
        }

        public List<User> Users {
            get;
            set;
        }
    }
}
