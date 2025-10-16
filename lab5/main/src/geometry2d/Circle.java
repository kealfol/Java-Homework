package geometry2d;

import Exceptions.InvalidRadiusException;
import java.io.IOException;
import java.util.logging.*;

public class Circle implements Figure {
    private static final Logger LOGGER = Logger.getLogger(Circle.class.getName());
    private double radius;

    static {
        try {
            FileHandler fh = new FileHandler("figures.log", true);
            fh.setFormatter(new XMLFormatter());
            fh.setLevel(Level.SEVERE);
            LOGGER.addHandler(fh);
            LOGGER.setUseParentHandlers(false); 
            LOGGER.setLevel(Level.SEVERE);
        } catch (IOException e) {
            System.err.println("Не удалось настроить логгер для Circle");
        }
    }

    public Circle(double radius) throws InvalidRadiusException {
        if (radius <= 0) {
            LOGGER.log(Level.SEVERE, "Недопустимый радиус: {0}", radius);
            throw new InvalidRadiusException("Радиус должен быть положительным.");
        }
        this.radius = radius;
        LOGGER.log(Level.SEVERE, "Создан круг с радиусом {0}", radius);
    }

    public double Area() {
        return Math.PI * radius * radius;
    }

    public void Show() {
        System.out.printf("Круг: радиус = %.2f, площадь = %.2f%n", radius, Area());
    }
}