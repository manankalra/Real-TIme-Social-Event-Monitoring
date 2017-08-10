package CosineSimilarity.SurfaceSimilarity.Helper;

import java.util.HashMap;

public class Counter<T> {
    final HashMap<T, Integer> counts = new HashMap<>();

    public void add(T t) {
        counts.merge(t, 1, Integer::sum);
    }

    public int count(T t) {
        return counts.getOrDefault(t, 0);
    }

    public HashMap<T, Integer> returnMap() {
        return counts;
    }
}
