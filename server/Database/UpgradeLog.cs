using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class UpgradeLog {
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

        public long BuildingId {
            get;
            set;
        }

        [ForeignKey("BuildingId")]
        public Building Building {
            get;
            set;
        }

        public int Level {
            get;
            set;
        }

        public DateTime Time {
            get;
            set;
        }
    }
}
