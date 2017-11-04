using System;
using Newtonsoft.Json;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.View {
    public class Vertex3 : IViewModel {
        public bool HasUpdated {
            get {
                return XHasUpdated || YHasUpdated || ZHasUpdated;
            }
        }

#region X
        double x;
        bool XHasUpdated = true;

        [JsonProperty("x")]
        public double X {
            get {
                return x;
            }
            set {
                x = value;
                XHasUpdated = true;
            }
        }

        public bool ShouldSerializeX() {
            bool val = XHasUpdated;
            if (val) {
                XHasUpdated = false;
            }
            return val;
        }
#endregion
#region Y
        double y;
        bool YHasUpdated = true;

        [JsonProperty("y")]
        public double Y {
            get {
                return y;
            }
            set {
                y = value;
                YHasUpdated = true;
            }
        }

        public bool ShouldSerializeY() {
            bool val = YHasUpdated;
            if (val) {
                YHasUpdated = false;
            }
            return val;
        }
#endregion
#region Z
        double z;
        bool ZHasUpdated = true;

        [JsonProperty("z")]
        public double Z {
            get {
                return z;
            }
            set {
                z = value;
                ZHasUpdated = true;
            }
        }

        public bool ShouldSerializeZ() {
            bool val = ZHasUpdated;
            if (val) {
                ZHasUpdated = false;
            }
            return val;
        }
#endregion
    }
}
