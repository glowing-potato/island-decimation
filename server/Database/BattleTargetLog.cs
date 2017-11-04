using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class BattleTargetLog {
        [Key]
        public virtual long Id {
            get;
            set;
        }

        public virtual long PlaceId {
            get;
            set;
        }

        [ForeignKey("PlaceId")]
        public virtual BattlePlaceLog Place {
            get;
            set;
        }

        public virtual double X {
            get;
            set;
        }

        public virtual double Y {
            get;
            set;
        }

        public virtual DateTime Time {
            get;
            set;
        }
    }
}
