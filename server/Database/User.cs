using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class User {
        [Key]
        public long Id {
            get;
            set;
        }

        public string Email {
            get;
            set;
        }

        public string PasswordHash {
            get;
            set;
        }

        public double Score {
            get;
            set;
        }

        public double Experience {
            get;
            set;
        }

        public long WorldId {
            get;
            set;
        }

        [ForeignKey("WorldId")]
        public World World {
            get;
            set;
        }

        public ICollection<Island> Islands {
            get;
            set;
        }
    }
}
