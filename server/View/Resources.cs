using System;
using Newtonsoft.Json;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.View {
    public class Resources : IViewModel {
        public bool HasUpdated {
            get {
                return WoodHasUpdated || WheatHasUpdated || IridiumHasUpdated;
            }
        }

#region Wood
        int wood;
        bool WoodHasUpdated = true;

        [JsonProperty("wood")]
        public int Wood {
            get {
                return wood;
            }
            set {
                wood = value;
                WoodHasUpdated = true;
            }
        }

        public bool ShouldSerializeWood() {
            bool val = WoodHasUpdated;
            if (val) {
                WoodHasUpdated = false;
            }
            return val;
        }
#endregion
#region Wheat
        int wheat;
        bool WheatHasUpdated = true;

        [JsonProperty("wheat")]
        public int Wheat {
            get {
                return wheat;
            }
            set {
                wheat = value;
                WheatHasUpdated = true;
            }
        }

        public bool ShouldSerializeWheat() {
            bool val = WheatHasUpdated;
            if (val) {
                WheatHasUpdated = false;
            }
            return val;
        }
#endregion
#region Iridium
        int iridium;
        bool IridiumHasUpdated = true;

        [JsonProperty("iridium")]
        public int Iridium {
            get {
                return iridium;
            }
            set {
                iridium = value;
                IridiumHasUpdated = true;
            }
        }

        public bool ShouldSerializeIridium() {
            bool val = IridiumHasUpdated;
            if (val) {
                IridiumHasUpdated = false;
            }
            return val;
        }
#endregion
    }
}
