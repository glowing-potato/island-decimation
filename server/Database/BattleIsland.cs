using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class BattleIsland {
        [Key]
        public ulong Id {
            get;
            set;
        }

        public ulong UserId {
            get;
            set;
        }

        [ForeignKey("UserId")]
        public User User {
            get;
            set;
        }

        public ulong BattleId {
            get;
            set;
        }

        [ForeignKey("BattleId")]
        public Battle Battle {
            get;
            set;
        }

        public decimal X {
            get;
            set;
        }

        public decimal y {
            get;
            set;
        }

        public string Code {
            get;
            set;
        }
    }
}
