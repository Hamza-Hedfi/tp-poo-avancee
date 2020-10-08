package com.deuterium.tp01;

public interface ElementGraphique {

    default void deplacer() {
        deplacer(0.0d, 0.0d);
    }

    void deplacer(Double deltaX, Double deltaY);

}
