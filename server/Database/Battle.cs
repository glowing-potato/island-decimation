using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Collections.Generic;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class Battle {
        [Key]
        public long Id {
            get;
            set;
        }

        public DateTime Time {
            get;
            set;
        }

        public long WinnerId {
            get;
            set;
        }

        [ForeignKey("WinnerId")]
        public Island Winner {
            get;
            set;
        }

        public ICollection<BattleIsland> Islands {
            get;
            set;
        }
    }
}
