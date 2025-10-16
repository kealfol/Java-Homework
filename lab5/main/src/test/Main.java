package test;

import Exceptions.InvalidHeightException;
import Exceptions.InvalidRadiusException;
import geometry2d.Circle;
import geometry2d.Figure;
import geometry2d.Rectangle;
import geometry3d.Cylinder;
import java.util.logging.*;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    static {
        ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new SimpleFormatter());
        ch.setLevel(Level.FINE);
        LOGGER.addHandler(ch);
        LOGGER.setUseParentHandlers(false);
        LOGGER.setLevel(Level.FINE);
    }

    public static void main(String[] args) {
        LOGGER.fine("Запуск программы");

        Circle circle = createCircle(5.0);
        Rectangle rectangle = createRectangle(4.0, 6.0);

        if (circle != null) circle.Show();
        if (rectangle != null) rectangle.Show();

        Cylinder c1 = createCylinder(circle, 10.0);
        Cylinder c2 = createCylinder(rectangle, 8.0);

        if (c1 != null) c1.Show();
        if (c2 != null) c2.Show();

        LOGGER.fine("Программа завершена");
    }

    private static Circle createCircle(double r) {
        try {
            LOGGER.log(Level.FINE, "Попытка создания круга с радиусом {0}", r);
            return new Circle(r);
        } catch (InvalidRadiusException e) {
            LOGGER.severe("Ошибка: " + e.getMessage());
            return null;
        }
    }

    private static Rectangle createRectangle(double w, double h) {
        try {
            LOGGER.log(Level.FINE, "Попытка создания прямоугольника: ширина={0}, высота={1}", new Object[]{w, h});
            return new Rectangle(w, h);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Ошибка: " + e.getMessage());
            return null;
        }
    }

    private static Cylinder createCylinder(Figure base, double h) {
        if (base == null) return null;
        try {
            LOGGER.log(Level.FINE, "Попытка создания цилиндра: основание={0}, высота={1}", new Object[]{base.getClass().getSimpleName(), h});
            return new Cylinder(base, h);
        } catch (InvalidHeightException e) {
            LOGGER.severe("Ошибка: " + e.getMessage());
            return null;
        }
    }
}