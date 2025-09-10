import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Задание №1");
        for(int i = 0; i <=500;i++){
            if((i % 5 == 0) && (i % 7 == 0)){
                System.out.println("fizzbuzz");
            } 
            else if(i % 7 == 0){
                System.out.println("buzz");
            }
            else if(i % 5 == 0){
                System.out.println("fizz");
            } else {
                System.out.println(i);
            }
        } 
        System.out.println("Задание №2");
        String mi = "make install";
        String mireverse = "";
        for(int i = mi.length() - 1; i >=0;i--){
            mireverse += mi.charAt(i);
        }
        System.out.println(mireverse);
        System.out.println("Задание №3");
        System.out.println("Enter a:");
        int a = (new Scanner(System.in)).nextInt();
        System.out.println("Enter b:");
        int b = (new Scanner(System.in)).nextInt();
        System.out.println("Enter c:");
        int c = (new Scanner(System.in)).nextInt();
        double Disc = (b*b - 4 * a * c);
        if (Disc > 0){
            double x1 = (-b - Math.sqrt(Disc)) / (2 * a);
            double x2 = (-b + Math.sqrt(Disc)) / (2 * a);
            System.out.println(x1);
            System.out.println(x2);
        }
        else if(Disc == 0){
            double x = (-b) / (2 * a);
            System.out.println(x);
        }
        else {
            System.out.println("Вещественных корней нет");
        }
        
        System.out.println("Задание №5");
        String Palindrom = (new Scanner(System.in)).nextLine();

        String PalindromReverse = "";
        for(int i = Palindrom.length() - 1; i >=0;i--){
            PalindromReverse += Palindrom.charAt(i);
        }
        if(Palindrom.equals(PalindromReverse)){
            System.out.printf("Строка: %s верная \n", PalindromReverse);
        }
    }
}
