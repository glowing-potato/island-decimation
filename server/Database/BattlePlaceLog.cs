using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Model;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class BattlePlaceLog {
        [Key]
        public long Id {
            get;
            set;
        }

        public long BattleIslandId {
            get;
            set;
        }

        [ForeignKey("BattleIslandId")]
        public BattleIsland BattleIsland {
            get;
            set;
        }

        public TroopType Type {
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

        public ICollection<BattleTargetLog> Targets {
            get;
            set;
        }
    }
}
