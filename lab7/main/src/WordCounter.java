import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        String text = "hello country note notebook was will run jump bye son son son will Was";

        Map<String, Integer> wordCount = new HashMap<>();

        String[] words = text.split("[\\s\\p{Punct}]+");

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount.merge(word, 1, Integer::sum);
            }
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}