package com.deuterium.tp01;

public class Triangle extends AbstractForm {

    static {
        MAX_POINTS = 3;
    }

    public Triangle() {
        points = new Point[MAX_POINTS];
    }

    public Triangle(Point[] points) {
        setPoints(points);
    }

    public void setPoints(Point[] points) {
        try {
            if (points.length != 2)
                throw new IllegalArgumentException("Un triangle doit avoir exactement " + MAX_POINTS + "points!");
            this.points = points;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

}
