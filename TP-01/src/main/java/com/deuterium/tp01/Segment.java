package com.deuterium.tp01;

import java.util.Arrays;

public class Segment extends AbstractForm {

    static {
        MAX_POINTS = 2;
    }

    public Segment() {
        points = new Point[MAX_POINTS];
    }

    public Segment(Point[] points) {
        setPoints(points);
    }

    public void setPoints(Point[] points) {
        try {
            if (points.length != 2)
                throw new IllegalArgumentException("Un segment doit avoir exactement " + MAX_POINTS + "points!");
            this.points = points;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Segment{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
