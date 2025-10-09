package geometry2d;

import Exceptions.InvalidRadiusException;

public class Circle implements Figure {
    private double radius;

    public Circle(double radius) throws InvalidRadiusException {
        if (radius <= 0) {
            throw new InvalidRadiusException("Радиус должен быть положительным числом.");
        }
        this.radius = radius;
    }

    public double Area() {
        return Math.PI * radius * radius;
    }

    public void Show() {
        System.out.printf("Круг: радиус = %.2f, площадь = %.2f%n", radius, Area());
    }
}