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
        int a = (new Scanner(System.in)).nextInt();
        int b = (new Scanner(System.in)).nextInt();
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
    }
}
