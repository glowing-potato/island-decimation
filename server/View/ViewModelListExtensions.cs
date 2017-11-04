using System;
using System.Collections.Generic;
using System.Linq;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.View {
    public static class ViewModelListExtensions {
        public static ViewModelList<T> ToViewModelList<T>(this IEnumerable<T> t) where T : IViewModel {
            return new ViewModelList<T>(t.ToList<T>());
        }
    }
}
