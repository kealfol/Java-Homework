//import java.util.Scanner;

public class App {
    public static int tribonacci(int n){
        int result = 1;
        if(0 <= n && n <= 1) {
            return(0);
        } else if (n == 2) {
            return 1;
        } else if (n > 2){
            return tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
        } else {return 0;}
    }
    public static void power(double a, int n){
        int prod = 1;
        if (n == 0){
            System.out.println(1);
        }
        for(int i = 1; i <=n;i++){
            prod *= a;
        }
        System.out.println(prod);
    }
    public static double powerRec(double a, int n){
        if (n == 0){
            return(1);
        }
        return a * powerRec(a, n - 1);
    }
    public static void triangle(int a, int b, int c){
        if (((a + b) > c) && ((a + c) > b) && ((b + c) > a)){
            System.out.println("Это треугольник");
        } else {System.out.println("Это не треугольник");}
    }
    public static void distance(double x1, double y1, double x2, double y2){
        double d = Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2-y1) * (y2-y1)));
        System.out.println(d);
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Задание №1");
        System.out.println("Ввод: triangle(1, 1, 2)");
        triangle(1, 1, 2);
        System.out.println("Ввод: triangle(7, 6, 10)");
        triangle(7, 6, 10);
        System.out.println("Ввод: triangle(20, 13, 17)");
        triangle(20, 13, 17);
        System.out.println("Задание №2");
        System.out.println("Ввод: (1,1) и (4,5)");
        distance(1, 1, 4, 5);
        System.out.println("Задание №3");
        System.out.println("Ввод: power(2, 4)");
        power(2, 4);
        System.out.println("Ввод power(3, 5)");
        power(3, 5);
        System.out.println("Задание №4");
        System.out.println("Ввод power(2, 3)");
        System.out.println(powerRec(2, 3));
        System.out.println("Задание №5");
        System.out.println("Ввод tribonacci(4)");
        System.out.println(tribonacci(4));
        System.out.println("Ввод tribonacci(5)");
        System.out.println(tribonacci(5));
        System.out.println("Ввод tribonacci(6)");
        System.out.println(tribonacci(6));
        System.out.println("Ввод tribonacci(7)");
        System.out.println(tribonacci(7));
    }
}
