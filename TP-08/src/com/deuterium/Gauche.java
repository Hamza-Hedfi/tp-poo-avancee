package com.deuterium;

import javax.swing.*;
import java.awt.*;

public class Gauche extends JPanel {
    public Gauche() {
        setLayout(new BorderLayout());
        add(new HautGauche(), BorderLayout.NORTH);
        add(new BasGauche(), BorderLayout.CENTER);
    }
}
