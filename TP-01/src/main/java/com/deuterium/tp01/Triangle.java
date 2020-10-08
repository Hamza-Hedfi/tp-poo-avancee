package com.deuterium.tp01;

public class Triangle extends AbstractForm {

    {
        MAX_POINTS = 3;
        EXC_MSG = "Un triangle doit avoir exactement " + MAX_POINTS + "points!";
    }

    public Triangle() {
        points = new Point[MAX_POINTS];
    }

    public Triangle(Point[] points) {
        setPoints(points);
    }


}
