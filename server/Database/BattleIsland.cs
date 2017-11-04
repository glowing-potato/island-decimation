using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class BattleIsland {
        [Key]
        public virtual long Id {
            get;
            set;
        }

        public virtual long IslandId {
            get;
            set;
        }

        [ForeignKey("IslandId")]
        public virtual Island Island {
            get;
            set;
        }

        public virtual long BattleId {
            get;
            set;
        }

        [ForeignKey("BattleId")]
        public virtual Battle Battle {
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

        ICollection<BattlePlaceLog> placeLogs;

        public virtual ICollection<BattlePlaceLog> PlaceLogs {
            get {
                if (placeLogs == null) {
                    placeLogs = new List<BattlePlaceLog>();
                }
                return placeLogs;
            }
            set {
                placeLogs = value;
            }
        }
    }
}
