using System;
using System.ComponentModel.DataAnnotations;
using System.Collections.Generic;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class World {
        [Key]
        public virtual long Id {
            get;
            set;
        }

        public virtual DateTime StartTime {
            get;
            set;
        }

        ICollection<User> users;

        public virtual ICollection<User> Users {
            get {
                if (users == null) {
                    users = new List<User>();
                }
                return users;
            }
            set {
                users = value;
            }
        }
    }
}
