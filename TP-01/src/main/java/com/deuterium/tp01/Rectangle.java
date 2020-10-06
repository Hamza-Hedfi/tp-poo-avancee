package com.deuterium.tp01;

public class Rectangle extends AbstractForm {

    static {
        MAX_POINTS = 4;
    }

    public Rectangle() {
        points = new Point[MAX_POINTS];
    }

    public Rectangle(Point[] points) {
        setPoints(points);
    }

    public void setPoints(Point[] points) {
        try {
            if (points.length != 2)
                throw new IllegalArgumentException("Un rectangle doit avoir exactement " + MAX_POINTS + "points!");
            this.points = points;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
