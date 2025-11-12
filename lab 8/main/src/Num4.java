import java.util.function.Function;

public class Num4 {
    public static void main(String[] args) {
        Function<Integer, String> classify = n -> {
            if (n > 0) return "Положительное число";
            if (n < 0) return "Отрицательное число";
            return "Ноль";
        };

        System.out.println(classify.apply(5));
        System.out.println(classify.apply(-3));
        System.out.println(classify.apply(0));
    }
}