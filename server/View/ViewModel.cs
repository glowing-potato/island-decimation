using System;
using Newtonsoft.Json;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.View {
    public class ViewModel : IViewModel {
        public bool HasUpdated {
            get {
                return UserIsland.HasUpdated || BattlingIslands.HasUpdated || Troops.HasUpdated || StateHasUpdated;
            }
        }

#region UserIsland
        [JsonProperty("userIsland")]
        public Island UserIsland;

        public bool ShouldSerializeUserIsland() {
            return UserIsland.HasUpdated;
        }
#endregion
#region BattlingIslands
        [JsonProperty("battlingIslands")]
        public ViewModelList<Island> BattlingIslands;

        public bool ShouldSerializeBattlingIslands() {
            return BattlingIslands.HasUpdatedAndClear();
        }
#endregion
#region Troops
        [JsonProperty("troops")]
        public ViewModelList<Troop> Troops;

        public bool ShouldSerializeTroops() {
            return Troops.HasUpdatedAndClear();
        }
#endregion
#region State
        ViewState state;
        bool StateHasUpdated = true;

        [JsonProperty("state")]
        public ViewState State {
            get {
                return state;
            }
            set {
                state = value;
                StateHasUpdated = true;
            }
        }

        public bool ShouldSerializeState() {
            bool val = StateHasUpdated;
            if (val) {
                StateHasUpdated = false;
            }
            return val;
        }
#endregion
    }
}
