package com.deuterium;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame {
    public MainFrame() throws IOException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(new Gauche(), BorderLayout.WEST);
        add(new Droite(), BorderLayout.CENTER);

        pack();
        setVisible(true);


    }
}
