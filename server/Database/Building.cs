using System;
using System.ComponentModel.DataAnnotations;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class Building {
        [Key]
        public ulong Id {
            get;
            set;
        }

        public BuildingType Type {
            get;
            set;
        }

        public decimal X {
            get;
            set;
        }

        public decimal Y {
            get;
            set;
        }

        public ushort Level {
            get;
            set;
        }
    }
}
