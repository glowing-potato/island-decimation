using System;
using System.ComponentModel.DataAnnotations;

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
    }
}
