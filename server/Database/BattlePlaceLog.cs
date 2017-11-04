using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class BattlePlaceLog {
        [Key]
        public ulong Id {
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

        public ulong IslandId {
            get;
            set;
        }

        [ForeignKey("IslandId")]
        public Island Island {
            get;
            set;
        }

        public TroopType Type {
            get;
            set;
        }

        public decimal X {
            get;
            set;
        }

        public decimal Y {
            get;
            set;
        }

        public DateTime Time {
            get;
            set;
        }
    }
}
