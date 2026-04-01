package Logic;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


class JaccardSimilarityTest {

    @Test
    void testCalculateSimilarity_PerfectMatch() {
        JaccardSimilarityStrategy strategy = new JaccardSimilarityStrategy();
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("apple", 1);
        map1.put("pineapple", 1);

        Map<String, Integer> map2 = new HashMap<>(map1);

        double result = strategy.calculateSimilarity(map1, map2);
        assertEquals(1.0, result, "For same maps, similarity must be 1.0.");
    }

    @Test
    void testCalculateSimilarity_NoMatch() {
        JaccardSimilarityStrategy strategy = new JaccardSimilarityStrategy();
        Map<String, Integer> map1 = Map.of("apple", 1);
        Map<String, Integer> map2 = Map.of("pineapple", 1);

        double result = strategy.calculateSimilarity(map1, map2);
        assertEquals(0.0, result, "If there is no common word similarity must be 0.0");
    }

    @Test
    void testCalculateSimilarity_PartialMatch() {
        JaccardSimilarityStrategy strategy = new JaccardSimilarityStrategy();
        Map<String, Integer> map1 = Map.of("a", 1, "b", 1);
        Map<String, Integer> map2 = Map.of("b", 1, "c", 1);

        double result = strategy.calculateSimilarity(map1, map2);
        assertEquals(1.0/3.0, result, 0.001, "Partial similarity must be calculated right");
    }

    @Test
    void testCalculateSimilarity_EmptyMaps() {
        JaccardSimilarityStrategy strategy = new JaccardSimilarityStrategy();
        double result = strategy.calculateSimilarity(new HashMap<>(), new HashMap<>());
        assertEquals(0.0, result, "Empty maps must return 0.0");
    }
}