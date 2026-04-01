package Logic;

import java.util.Map;

public interface SimilarityStrategy {
    double calculateSimilarity(Map<String, Integer> map1, Map<String, Integer> map2);
}
