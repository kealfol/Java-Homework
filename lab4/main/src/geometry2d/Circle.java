package geometry2d;

public class Circle implements Figure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double Area() {
        return Math.PI * radius * radius;
    }

    public void Show() {
        System.out.printf("Круг: радиус = %.2f, площадь = %.2f%n", radius, Area());
    }
}