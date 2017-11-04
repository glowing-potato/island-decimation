using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class UpgradeLog {
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

        public virtual long BuildingId {
            get;
            set;
        }

        [ForeignKey("BuildingId")]
        public virtual Building Building {
            get;
            set;
        }

        public virtual int Level {
            get;
            set;
        }

        public virtual DateTime Time {
            get;
            set;
        }
    }
}
