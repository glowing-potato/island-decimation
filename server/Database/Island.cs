using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.Database {
    public class Island {
        [Key]
        public ulong Id {
            get;
            set;
        }

        public ulong UserId {
            get;
            set;
        }

        [ForeignKey("UserId")]
        public User User {
            get;
            set;
        }

        public decimal ShapeX {
            get;
            set;
        }

        public decimal ShapeY {
            get;
            set;
        }

        public decimal Wood {
            get;
            set;
        }

        public decimal Wheat {
            get;
            set;
        }

        public decimal Iridium {
            get;
            set;
        }

        public string Code {
            get;
            set;
        }
    }
}
