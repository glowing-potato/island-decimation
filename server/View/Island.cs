using System;
using System.Collections.Generic;
using Newtonsoft.Json;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.View {
    public class Island : IViewModel {
        public bool HasUpdated {
            get {
                return ScoreHasUpdated || ExperienceHasUpdated || Resources.HasUpdated || TerrainHasUpdated || Buildings.HasUpdated || AngleHasUpdated;
            }
        }

#region Score
        double score;
        bool ScoreHasUpdated;

        [JsonProperty("score")]
        public double Score {
            get {
                return score;
            }
            set {
                score = value;
                ScoreHasUpdated = true;
            }
        }

        public bool ShouldSerializeScore() {
            bool val = ScoreHasUpdated;
            if (val) {
                ScoreHasUpdated = false;
            }
            return val;
        }
#endregion
#region Experience
        double experience;
        bool ExperienceHasUpdated;

        [JsonProperty("experience")]
        public double Experience {
            get {
                return experience;
            }
            set {
                experience = value;
                ExperienceHasUpdated = true;
            }
        }

        public bool ShouldSerializeExperience() {
            bool val = ExperienceHasUpdated;
            if (val) {
                ExperienceHasUpdated = false;
            }
            return val;
        }
#endregion
#region Resources
        [JsonProperty("resources")]
        public Resources Resources;

        public bool ShouldSerializeResources() {
            return Resources.HasUpdated;
        }
#endregion
#region Terrain
        long terrain;
        bool TerrainHasUpdated;

        [JsonProperty("terrain")]
        public long Terrain {
            get {
                return terrain;
            }
            set {
                terrain = value;
                TerrainHasUpdated = true;
            }
        }

        public bool ShouldSerializeTerrain() {
            bool val = TerrainHasUpdated;
            if (val) {
                TerrainHasUpdated = false;
            }
            return val;
        }
#endregion
#region Buildings
        [JsonProperty("buildings")]
        public ViewModelList<Building> Buildings;

        public bool ShouldSerializeBuildings() {
            return Buildings.HasUpdated;
        }
#endregion
#region Angle
        double angle;
        bool AngleHasUpdated;

        [JsonProperty("angle")]
        public double Angle {
            get {
                return angle;
            }
            set {
                angle = value;
                AngleHasUpdated = true;
            }
        }

        public bool ShouldSerializeAngle() {
            bool val = AngleHasUpdated;
            if (val) {
                AngleHasUpdated = false;
            }
            return val;
        }
#endregion
    }
}
