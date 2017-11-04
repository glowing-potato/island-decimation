using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class User {
        [Key]
        public virtual long Id {
            get;
            set;
        }

        public virtual string Email {
            get;
            set;
        }

        public virtual string PasswordHash {
            get;
            set;
        }

        public virtual double Score {
            get;
            set;
        }

        public virtual double Experience {
            get;
            set;
        }

        public virtual long WorldId {
            get;
            set;
        }

        [ForeignKey("WorldId")]
        public virtual World World {
            get;
            set;
        }

        ICollection<Island> islands;

        public virtual ICollection<Island> Islands {
            get {
                if (islands == null) {
                    islands = new List<Island>();
                }
                return islands;
            }
            set {
                islands = value;
            }
        }
    }
}
