using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

namespace Com.GitHub.GlowingPotato.IslandDecimation.Server.View {
    public class ViewModelList<T> : IList<T>, IViewModel where T : IViewModel {
        bool hasUpdated = true;
        List<T> List;

        public bool HasUpdated {
            get {
                return hasUpdated || this.Any(o => o.HasUpdated);
            }
        }

        public bool HasUpdatedAndClear() {
            bool val = HasUpdated;
            if (val) {
                hasUpdated = false;
            }
            return val;
        }

        public T this[int index] {
            get {
                return List[index];
            }
            set {
                List[index] = value;
                hasUpdated = true;
            }
        }

        public int Count {
            get {
                return List.Count;
            }
        }

        public bool IsReadOnly {
            get {
                return false;
            }
        }

        public void Add(T item) {
            List.Add(item);
            hasUpdated = true;
        }

        public void Clear() {
            throw new NotSupportedException();
        }

        public bool Contains(T item) {
            return List.Contains(item);
        }

        public void CopyTo(T[] array, int arrayIndex) {
            List.CopyTo(array, arrayIndex);
        }

        public IEnumerator<T> GetEnumerator() {
            return List.GetEnumerator();
        }

        public int IndexOf(T item) {
            return List.IndexOf(item);
        }

        public void Insert(int index, T item) {
            throw new NotSupportedException();
        }

        public bool Remove(T item) {
            int index = IndexOf(item);
            if (index < 0) {
                return false;
            } else {
                RemoveAt(index);
                return true;
            }
        }

        public void RemoveAt(int index) {
            this[index] = default(T);
        }

        IEnumerator IEnumerable.GetEnumerator() {
            return List.GetEnumerator();
        }

        public ViewModelList(List<T> list) {
            List = list;
        }

        public ViewModelList() : this(new List<T>()) {
        }
    }
}
