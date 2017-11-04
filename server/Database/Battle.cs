using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class Battle {
        [Key]
        public ulong Id {
            get;
            set;
        }

        public DateTime Time {
            get;
            set;
        }

        public ulong WinnerId {
            get;
            set;
        }

        [ForeignKey("WinnerId")]
        public User Winner {
            get;
            set;
        }
    }
}
