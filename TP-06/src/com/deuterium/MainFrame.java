package com.deuterium;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final ToolBar toolBar;
    private final DrawArea drawArea;

    public MainFrame() {
        super("TP-06 OOP-A __ Hamza Hadfi");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        toolBar = new ToolBar();
        drawArea = new DrawArea();

        toolBar.setDrawListener(new DrawListener() {
            @Override
            public void drawLune() {
                drawArea.drawLune();
            }

            @Override
            public void drawSoleil() {
                drawArea.drawSoleil();
            }

            @Override
            public void drawCroissant() {
                drawArea.drawCroissant();
            }
        });

        add(toolBar, BorderLayout.NORTH);
        add(drawArea, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
