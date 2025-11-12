import java.util.function.Predicate;

public class Num1 {
    public static void main(String[] args) {
        Predicate<String> isNotNull = str -> str != null;
        Predicate<String> isNotEmpty = str -> !str.trim().isEmpty();
        Predicate<String> isNotNullAndNotEmpty = isNotNull.and(isNotEmpty);

        String[] tests = {
            "Hello",
             "",
             "   ",
             null,
            "Java"};

        for (int i = 0; i < tests.length; i++) {
            String s = tests[i];
            boolean result = isNotNullAndNotEmpty.test(s);
            System.out.println("Тест " + (i + 1) + ":" + result);
        }
    }
}