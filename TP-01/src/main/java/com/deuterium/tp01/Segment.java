package com.deuterium.tp01;

public class Segment extends AbstractForm {

    {
        EXC_MSG = "Un segment doit avoir exactement " + MAX_POINTS + "points!";
        MAX_POINTS = 2;
    }

    public Segment() {
        points = new Point[MAX_POINTS];
    }

    public Segment(Point[] points) {
        setPoints(points);
    }
}
