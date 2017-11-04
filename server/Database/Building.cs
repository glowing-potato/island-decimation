using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Model;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class Building {
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

        public virtual BuildingType Type {
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

        public virtual int Level {
            get;
            set;
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
    }
}
