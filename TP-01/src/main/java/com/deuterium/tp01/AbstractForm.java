package com.deuterium.tp01;

import java.util.Arrays;

public abstract class AbstractForm implements ElementGraphique {

    protected Point[] points;
    protected short MAX_POINTS;
    protected String EXC_MSG;

    @Override
    public void deplacer(Double deltaX, Double deltaY) {
        Arrays.stream(points).forEach(point -> point.deplacer(deltaX, deltaY));
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
                "points=" + Arrays.toString(points) +
                '}';
    }

    public void setPoints(Point[] points) {
        try {
            if (points.length != 2) {
                throw new IllegalArgumentException(EXC_MSG);
            }
            this.points = points;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
