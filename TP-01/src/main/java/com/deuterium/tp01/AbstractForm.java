package com.deuterium.tp01;

import java.util.Arrays;

public abstract class AbstractForm implements ElementGraphique {

    protected static short MAX_POINTS;
    protected Point[] points;

    @Override
    public void deplacer(Double deltaX, Double deltaY) {
        Arrays.stream(points).forEach(point -> point.deplacer(deltaX, deltaY));
    }
}
