package Manager;

import Logic.FileReaderThread;
import Logic.SimilarityCalculator;
import java.util.concurrent.ConcurrentHashMap;

public class SimilarityManager {

    private SimilarityCalculator calculator;

    public SimilarityManager(SimilarityCalculator calculator) {
        this.calculator = calculator;
    }

    public double process(String path1, String path2) {
        var map1 = new ConcurrentHashMap<String, Integer>();
        var map2 = new ConcurrentHashMap<String, Integer>();

        Thread t1 = new Thread(new FileReaderThread(path1, map1));
        Thread t2 = new Thread(new FileReaderThread(path2, map2));

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();

            double result = calculator.calculateSimilarity(map1, map2);
            return result * 100;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

}
