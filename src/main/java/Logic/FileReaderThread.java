    package Logic;

    import javax.swing.*;
    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.Map;

    public class FileReaderThread implements Runnable {
        private final String filePath;
        private Map<String, Integer> targetMap;

        public FileReaderThread(String filePath, Map<String, Integer> targetMap) {
            this.filePath = filePath;
            this.targetMap = targetMap;
        }
        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] words = line.toLowerCase().trim().split(" ");

                        for (String word : words) {
                            targetMap.merge(word, 1, Integer::sum);
                        }
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + filePath);
            }
        }
    }
