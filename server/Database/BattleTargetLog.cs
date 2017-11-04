using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class BattleTargetLog {
        [Key]
        public long Id {
            get;
            set;
        }

        public long PlaceId {
            get;
            set;
        }

        [ForeignKey("PlaceId")]
        public BattlePlaceLog Place {
            get;
            set;
        }

        public double X {
            get;
            set;
        }

        public double Y {
            get;
            set;
        }

        public DateTime Time {
            get;
            set;
        }
    }
}
