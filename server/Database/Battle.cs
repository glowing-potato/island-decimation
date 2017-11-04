using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Collections.Generic;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class Battle {
        [Key]
        public virtual long Id {
            get;
            set;
        }

        public virtual DateTime Time {
            get;
            set;
        }

        public virtual long WinnerId {
            get;
            set;
        }

        [ForeignKey("WinnerId")]
        public virtual Island Winner {
            get;
            set;
        }

        ICollection<BattleIsland> islands;

        public virtual ICollection<BattleIsland> Islands {
            get {
                if (islands == null) {
                    islands = new List<BattleIsland>();
                }
                return islands;
            }
            set {
                islands = value;
            }
        }
    }
}
