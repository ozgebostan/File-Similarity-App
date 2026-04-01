package Logic;


import java.util.Map;

//Composite pattern context
public class SimilarityCalculator {

    private SimilarityStrategy strategy;

    public SimilarityCalculator(SimilarityStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateSimilarity(Map<String, Integer> map1, Map<String, Integer> map2) {
        return strategy.calculateSimilarity(map1, map2);
    }
}
