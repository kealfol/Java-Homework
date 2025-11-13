import java.util.function.Predicate;

public class Num2 {
    public static void main(String[] args) {
        Predicate<String> check = str -> {
            if (str == null || str.isEmpty()) {
                return false;
            }
            return (str.startsWith("J") || str.startsWith("N")) && str.endsWith("A");
        };

        System.out.println("Тест \"Java\": " + check.test("Java"));
        System.out.println("Тест \"NiceA\": " + check.test("NiceA"));
        System.out.println("Тест \"Hello\": " + check.test("Hello"));
        System.out.println("Тест \"Jazz\": " + check.test("Jazz"));
        System.out.println("Тест \"NA\": " + check.test("NA"));
        System.out.println("Тест \"\": " + check.test(""));
        System.out.println("Тест null: " + check.test(null));
    }
}