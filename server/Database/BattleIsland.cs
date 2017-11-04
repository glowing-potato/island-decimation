using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class BattleIsland {
        [Key]
        public long Id {
            get;
            set;
        }

        public long IslandId {
            get;
            set;
        }

        [ForeignKey("IslandId")]
        public Island Island {
            get;
            set;
        }

        public long BattleId {
            get;
            set;
        }

        [ForeignKey("BattleId")]
        public Battle Battle {
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
    }
}
