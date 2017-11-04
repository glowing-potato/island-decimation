using System;
using Newtonsoft.Json;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.View {
    public class Vertex2 : IViewModel {
        public bool HasUpdated {
            get {
                return XHasUpdated || YHasUpdated;
            }
        }

#region X
        double x;
        bool XHasUpdated;

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
        bool YHasUpdated;

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
    }
}
