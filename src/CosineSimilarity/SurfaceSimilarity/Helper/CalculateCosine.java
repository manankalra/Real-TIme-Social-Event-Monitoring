package CosineSimilarity.SurfaceSimilarity.Helper;


import java.util.HashMap;
import java.util.HashSet;

public class CalculateCosine {
    public float calculate(HashMap<String, Integer> vec1, HashMap<String, Integer> vec2) {
        HashSet<String> intersection = new HashSet(vec1.keySet());
        intersection.retainAll(vec2.keySet());
        int numerator = 0, sum1 = 0, sum2 = 0;
        for (String s : intersection) {
            numerator += vec1.get(s) * vec2.get(s);
        }
        for (String s : vec1.keySet()) {
            sum1 += Math.pow(vec1.get(s), 2);
        }
        for (String t : vec2.keySet()) {
            sum2 += Math.pow(vec2.get(t), 2);
        }
        double denominator = Math.sqrt(sum1) * Math.sqrt(sum2);
        return (float) numerator / (float) denominator;
    }
}