package geometry2d;

import java.io.IOException;
import java.util.logging.*;

public class Rectangle implements Figure {
    private static final Logger LOGGER = Logger.getLogger(Rectangle.class.getName());
    private double width;
    private double height;

    static {
        try {
            FileHandler fh = new FileHandler("figures.log", true);
            fh.setFormatter(new XMLFormatter());
            fh.setLevel(Level.INFO);
            LOGGER.addHandler(fh);
            LOGGER.setUseParentHandlers(false);
            LOGGER.setLevel(Level.INFO);
        } catch (IOException e) {
            System.err.println("Не удалось настроить логгер для Rectangle");
        }
    }

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            LOGGER.log(Level.INFO, "Недопустимые размеры: ширина={0}, высота={1}", new Object[]{width, height});
            throw new IllegalArgumentException("Размеры должны быть положительными.");
        }
        this.width = width;
        this.height = height;
        LOGGER.log(Level.INFO, "Создан прямоугольник: ширина={0}, высота={1}", new Object[]{width, height});
    }

    public double Area() {
        return width * height;
    }

    public void Show() {
        System.out.printf("Прямоугольник: ширина = %.2f, высота = %.2f, площадь = %.2f%n", width, height, Area());
    }
}