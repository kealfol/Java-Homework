import java.util.ArrayList;
import java.util.List;

public class OddEvenSeparator {
    private List<Integer> evenNumbers = new ArrayList<>();  
    private List<Integer> oddNumbers = new ArrayList<>();  

    public void addNumber(int number) {
        if (number % 2 == 0) {
            evenNumbers.add(number);
        } else {
            oddNumbers.add(number);
        }
    }

    public void even() {
        System.out.print("Чётные: ");
        for (int i = 0; i < evenNumbers.size(); i++) {
            int num = evenNumbers.get(i);
            System.out.print(+ num + " ");
        }
        System.out.println(); 
    }

    public void odd() {
        System.out.print("Нечётные: ");
        for (int i = 0; i < oddNumbers.size(); i++) {
            int num = oddNumbers.get(i);
            System.out.print(+ num + " ");
        }
        System.out.println();
    }
}