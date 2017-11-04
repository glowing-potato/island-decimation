using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class Island {
        [Key]
        public virtual long Id {
            get;
            set;
        }

        public virtual long UserId {
            get;
            set;
        }

        [ForeignKey("UserId")]
        public virtual User User {
            get;
            set;
        }

        public virtual long Terrain {
            get;
            set;
        }

        public virtual int Wood {
            get;
            set;
        }

        public virtual int Wheat {
            get;
            set;
        }

        public virtual int Iridium {
            get;
            set;
        }

        public virtual string Code {
            get;
            set;
        }

        ICollection<Building> buildings;

        public virtual ICollection<Building> Buildings {
            get {
                if (buildings == null) {
                    buildings = new List<Building>();
                }
                return buildings;
            }
            set {
                buildings = value;
            }
        }

        ICollection<UpgradeLog> upgradeLogs;

        public virtual ICollection<UpgradeLog> UpgradeLogs {
            get {
                if (upgradeLogs == null) {
                    upgradeLogs = new List<UpgradeLog>();
                }
                return upgradeLogs;
            }
            set {
                upgradeLogs = value;
            }
        }

        ICollection<Battle> battles;

        public virtual ICollection<Battle> Battles {
            get {
                if (battles == null) {
                    battles = new List<Battle>();
                }
                return battles;
            }
            set {
                battles = value;
            }
        }
    }
}
