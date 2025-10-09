package geometry3d;

import Exceptions.InvalidHeightException;
import geometry2d.Figure;

public class Cylinder {
    private Figure base; 
    private double height;

    public Cylinder(Figure base, double height) throws InvalidHeightException {
        if (height <= 0) {
            throw new InvalidHeightException("Высота цилиндра должна быть положительной.");
        }
        this.base = base;
        this.height = height;
    }

    public double Volume() {
        return base.Area() * height;
    }

    public void Show() {
        System.out.printf("Цилиндр: основание = %s, высота = %.2f, объем = %.2f%n", base.getClass().getSimpleName(), height, Volume());
    }
}