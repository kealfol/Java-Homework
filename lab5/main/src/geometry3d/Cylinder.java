package geometry3d;

import Exceptions.InvalidHeightException;
import geometry2d.Figure;
import java.io.IOException;
import java.util.logging.*;

public class Cylinder {
    private static final Logger LOGGER = Logger.getLogger(Cylinder.class.getName());
    private Figure base;
    private double height;

    static {
        try {
            FileHandler fh = new FileHandler("cylinder.log", true);
            fh.setFormatter(new SimpleFormatter()); // человекочитаемый
            fh.setLevel(Level.FINEST);
            LOGGER.addHandler(fh);
            LOGGER.setUseParentHandlers(false);
            LOGGER.setLevel(Level.FINEST);
        } catch (IOException e) {
            System.err.println("Не удалось настроить логгер для Cylinder");
        }
    }

    public Cylinder(Figure base, double height) throws InvalidHeightException {
        if (height <= 0) {
            LOGGER.log(Level.FINEST, "Недопустимая высота цилиндра: {0}", height);
            throw new InvalidHeightException("Высота должна быть положительной.");
        }
        this.base = base;
        this.height = height;
        LOGGER.log(Level.FINEST, "Создан цилиндр: основание={0}, высота={1}",
                new Object[]{base.getClass().getSimpleName(), height});
    }

    public double Volume() {
        return base.Area() * height;
    }

    public void Show() {
        System.out.printf("Цилиндр: основание = %s, высота = %.2f, объем = %.2f%n",
                base.getClass().getSimpleName(), height, Volume());
        System.out.print("Информация об основании: ");
        base.Show();
    }
}