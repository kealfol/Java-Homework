import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        Integer[] array = {5, 3, 8, 3, 9, 1, 5, 2, 8, 4};
        
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("b) " + list);
        
        Collections.sort(list);
        System.out.println("c) " + list);
        
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("d) " + list);
        
        Collections.shuffle(list);
        System.out.println("e) " + list);
        
        Collections.rotate(list, 1);
        System.out.println("f) " + list);
        
        Set<Integer> uniqueSet = new LinkedHashSet<>(list);
        list.clear();
        list.addAll(uniqueSet);
        System.out.println("g) " + list);
        
        List<Integer> original = new ArrayList<>(Arrays.asList(array));
        List<Integer> duplicates = new ArrayList<>();
        for (Integer num : original) {
            if (Collections.frequency(original, num) > 1) {
                duplicates.add(num);
            }
        }
        duplicates = new ArrayList<>(new LinkedHashSet<>(duplicates));
        System.out.println("h) " + duplicates);
        
        Integer[] resultArray = list.toArray(new Integer[0]);
        System.out.println("i) " + Arrays.toString(resultArray));
    }
}
