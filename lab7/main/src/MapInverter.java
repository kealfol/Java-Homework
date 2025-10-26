import java.util.*;

public class MapInverter {

    public static <K, V> Map<V, Collection<K>> invertMap(Map<K, V> map) {
        Map<V, Collection<K>> inverted = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            inverted.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        return inverted;
    }

    public static void main(String[] args) {
        Map<String, Integer> original = new HashMap<>();
        original.put("a", 1);
        original.put("b", 2);
        original.put("c", 1);
        original.put("d", 3);
        original.put("e", 2);

        System.out.println("Исходная карта: " + original);

        Map<Integer, Collection<String>> inverted = invertMap(original);

        System.out.println("Инвертированная карта: " + inverted);
    }
}