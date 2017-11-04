using System;
using Newtonsoft.Json;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Model;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.View {
    public class Troop : IViewModel {
        public bool HasUpdated {
            get {
                return TypeHasUpdated || Position.HasUpdated || Target.HasUpdated || IslandIndexHasUpdated;
            }
        }

#region Type
        TroopType type;
        bool TypeHasUpdated = true;

        [JsonProperty("type")]
        public TroopType Type {
            get {
                return type;
            }
            set {
                type = value;
                TypeHasUpdated = true;
            }
        }

        public bool ShouldSerializeType() {
            return TypeHasUpdated;
        }
#endregion
#region Position
        [JsonProperty("pos")]
        public Vertex2 Position;

        public bool ShouldSerializePosition() {
            return Position.HasUpdated;
        }
#endregion
#region Target
        [JsonProperty("target")]
        public Vertex2 Target;

        public bool ShouldSerializeTarget() {
            return Target.HasUpdated;
        }
#endregion
#region IslandIndex
        int islandIndex;
        bool IslandIndexHasUpdated = true;

        [JsonProperty("island")]
        public int IslandIndex {
            get {
                return islandIndex;
            }
            set {
                islandIndex = value;
                IslandIndexHasUpdated = true;
            }
        }

        public bool ShouldSerializeIslandIndex() {
            bool val = IslandIndexHasUpdated;
            if (val) {
                IslandIndexHasUpdated = false;
            }
            return val;
        }
#endregion
    }
}
