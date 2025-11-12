import java.util.*;
import java.util.stream.Collectors;

public class Num6 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "Apricot");
        Collection<String> coll = Arrays.asList("first", "second", "third");
        int[] arr = {1, 3, 4, 7, 8};

        double avg = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println(avg);

        List<String> upperPrefixed = strings.stream()
                .map(s -> "new" + s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(upperPrefixed);

        List<Integer> squares = numbers.stream()
                .distinct()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(squares);

        List<String> filteredSorted = strings.stream()
                .filter(s -> s.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());
        System.out.println(filteredSorted);

        String last = coll.stream().reduce((first, second) -> second).orElseThrow();
        System.out.println(last);

        int sumEven = Arrays.stream(arr).filter(n -> n % 2 == 0).sum();
        System.out.println(sumEven);

        Map<Character, String> map = strings.stream()
                .collect(Collectors.toMap(
                        s -> s.charAt(0),
                        s -> s.substring(1),
                        (old, newV) -> old
                ));
        System.out.println(map);
    }
}