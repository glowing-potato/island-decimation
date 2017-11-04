using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class UpgradeLog {
        [Key]
        public ulong Id {
            get;
            set;
        }

        public ulong IslangId {
            get;
            set;
        }

        [ForeignKey("IslandId")]
        public Island Island {
            get;
            set;
        }

        public ulong BuildingId {
            get;
            set;
        }

        [ForeignKey("BuildingId")]
        public Building Building {
            get;
            set;
        }

        public ushort Level {
            get;
            set;
        }

        public DateTime Time {
            get;
            set;
        }
    }
}
