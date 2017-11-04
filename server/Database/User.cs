using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class User {
        [Key]
        public ulong Id {
            get;
            set;
        }

        public ulong WorldId {
            get;
            set;
        }

        [ForeignKey("WorldId")]
        public World World {
            get;
            set;
        }

        public ulong IslandId {
            get;
            set;
        }

        [ForeignKey("IslandId")]
        public Island Island {
            get;
            set;
        }

        public string Username {
            get;
            set;
        }

        public string PasswordHash {
            get;
            set;
        }

        public decimal Score {
            get;
            set;
        }

        public decimal Experience {
            get;
            set;
        }
    }
}
