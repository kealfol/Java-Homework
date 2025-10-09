package test;

import Exceptions.InvalidHeightException;
import Exceptions.InvalidRadiusException;
import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry3d.Cylinder;

public class Main {
    public static void main(String[] args) {
        try {
            Circle circle = new Circle(5.0);
            Rectangle rectangle = new Rectangle(4.0, 6.0);

            circle.Show();
            rectangle.Show();

            Cylinder cylinder1 = new Cylinder(circle, 10.0);
            Cylinder cylinder2 = new Cylinder(rectangle, 8.0);

            cylinder1.Show();
            cylinder2.Show();

            Circle invalidCircle = new Circle(-3.0);
        } catch (InvalidRadiusException e) {
            System.err.println("Ошибка при создании круга: " + e.getMessage());
        } catch (InvalidHeightException e) {
            System.err.println("Ошибка при создании цилиндра: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка при создании прямоугольника: " + e.getMessage());
        }
        
    }
}