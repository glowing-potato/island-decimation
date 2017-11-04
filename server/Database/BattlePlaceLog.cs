using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Model;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class BattlePlaceLog {
        [Key]
        public virtual long Id {
            get;
            set;
        }

        public virtual long BattleIslandId {
            get;
            set;
        }

        [ForeignKey("BattleIslandId")]
        public virtual BattleIsland BattleIsland {
            get;
            set;
        }

        public virtual TroopType Type {
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

        ICollection<BattleTargetLog> targets;

        public virtual ICollection<BattleTargetLog> Targets {
            get {
                if (targets == null) {
                    targets = new List<BattleTargetLog>();
                }
                return targets;
            }
            set {
                targets = value;
            }
        }
    }
}
