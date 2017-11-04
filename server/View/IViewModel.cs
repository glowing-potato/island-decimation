using System;
using Newtonsoft.Json;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.View {
    public interface IViewModel {
        [JsonIgnore]
        bool HasUpdated {
            get;
        }
    }
}
