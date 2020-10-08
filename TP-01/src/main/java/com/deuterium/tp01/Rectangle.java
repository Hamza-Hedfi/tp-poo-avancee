package com.deuterium.tp01;

public class Rectangle extends AbstractForm {

    {
        MAX_POINTS = 4;
        EXC_MSG = "Un rectangle doit avoir exactement " + MAX_POINTS + "points!";
    }

    public Rectangle() {
        points = new Point[MAX_POINTS];
    }

    public Rectangle(Point[] points) {
        setPoints(points);
    }
}
