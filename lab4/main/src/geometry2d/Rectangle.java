package geometry2d;

public class Rectangle implements Figure {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double Area() {
        return width * height;
    }

    public void Show() {
        System.out.printf("Прямоугольник: ширина = %.2f, высота = %.2f, площадь = %.2f%n",
                width, height, Area());
    }
}