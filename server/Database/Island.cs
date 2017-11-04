using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class Island {
        [Key]
        public long Id {
            get;
            set;
        }

        public long UserId {
            get;
            set;
        }

        [ForeignKey("UserId")]
        public User User {
            get;
            set;
        }

        public long Terrain {
            get;
            set;
        }

        public int Wood {
            get;
            set;
        }

        public int Wheat {
            get;
            set;
        }

        public int Iridium {
            get;
            set;
        }

        public string Code {
            get;
            set;
        }

        public ICollection<Building> Buildings {
            get;
            set;
        }

        public ICollection<UpgradeLog> UpgradeLogs {
            get;
            set;
        }

        public ICollection<Battle> Battles {
            get;
            set;
        }
    }
}
