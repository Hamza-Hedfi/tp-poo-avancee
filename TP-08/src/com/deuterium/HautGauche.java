package com.deuterium;

import javax.swing.*;
import java.awt.*;

public class HautGauche extends JPanel {
    public HautGauche() {
        setBorder(BorderFactory.createTitledBorder("Text Fields"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        Panel p1 = new Panel();
        p1.add(new JLabel("JTextField: "));
        p1.add(new JTextField("Hello", 15));

        Panel p2 = new Panel();
        p2.add(new JLabel("JPasswordField: "));
        p2.add(new JPasswordField(15));

        Panel p3 = new Panel();
        p3.add(new JLabel("JFormattedTextField: "));
        p3.add(new JFormattedTextField());

        Panel p4 = new Panel();
        p4.add(new JLabel("PASSWORD WILL SHOW HERE"));


        add(p1);
        add(p2);
        add(p3);
        add(p4);

//        setBackground(Color.BLACK);
        setSize(20, 50);
    }
}
