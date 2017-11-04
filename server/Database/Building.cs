using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Model;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class Building {
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

        public BuildingType Type {
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

        public int Level {
            get;
            set;
        }
    }
}
