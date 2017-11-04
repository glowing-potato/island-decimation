using System;
using Newtonsoft.Json;
using Com.GitHub.GlowingPotato.IslandDecimation.Server.Model;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.View {
    public class Building : IViewModel {
        public bool HasUpdated {
            get {
                return TypeHasUpdated || Position.HasUpdated || LevelHasUpdated;
            }
        }

#region Type
        BuildingType type;
        bool TypeHasUpdated = true;

        [JsonProperty("type")]
        public BuildingType Type {
            get {
                return type;
            }
            set {
                type = value;
                TypeHasUpdated = true;
            }
        }

        public bool ShouldSerializeType() {
            bool val = TypeHasUpdated;
            if (val) {
                TypeHasUpdated = false;
            }
            return val;
        }
#endregion
#region Position
        [JsonProperty("pos")]
        public Vertex2 Position;

        public bool ShouldSerializePosition() {
            return Position.HasUpdated;
        }
#endregion
#region Level
        int level;
        bool LevelHasUpdated = true;

        [JsonProperty("level")]
        public int Level {
            get {
                return level;
            }
            set {
                level = value;
                LevelHasUpdated = true;
            }
        }

        public bool ShouldSerializeLevel() {
            bool val = LevelHasUpdated;
            if (val) {
                LevelHasUpdated = false;
            }
            return val;
        }
#endregion
    }
}
