package Logic;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//composite pattern leaf
public class JaccardSimilarityStrategy implements SimilarityStrategy {


    @Override
    public double calculateSimilarity(Map<String, Integer> map1, Map<String, Integer> map2) {
        Set<String> union = new HashSet<>(map1.keySet());
        union.addAll(map2.keySet());

        Set<String> intersection = new HashSet<>(map1.keySet());
        intersection.retainAll(map2.keySet());

        if (union.isEmpty()) return 0.0;

        return (double) intersection.size() / union.size();
    }
}
