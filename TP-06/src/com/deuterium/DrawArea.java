package com.deuterium;

import javax.swing.*;
import java.awt.*;

public class DrawArea extends JPanel {

    public DrawArea() {

        setBackground(Color.BLACK);

        setPreferredSize(new Dimension(600, 500));
    }

    public void drawLune() {
        Graphics g = this.getGraphics();

        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(new Color(245, 243, 221));

        int luneWidth = 250;
        int luneHeight = 230;

        int x = (getWidth() / 2) - (luneWidth / 2);
        int y = (getHeight() / 2) - (luneHeight / 2);

        g.fillOval(x, y, luneWidth, luneHeight);
    }

    public void drawSoleil() {
        Graphics g = this.getGraphics();


        g.setColor(Color.BLUE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(new Color(239, 142, 56));

        int sunWidth = 270;
        int sunHeight = 250;

        int x = (getWidth() / 2) - (sunWidth / 2);
        int y = (getHeight() / 2) - (sunHeight / 2);

        g.fillOval(x, y, sunWidth, sunHeight);
    }

    public void drawCroissant() {
        Graphics g = this.getGraphics();

        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(Color.WHITE);

        int width = 270;
        int height = 270;

        int x = (getWidth() / 2) - (width / 2);
        int y = (getHeight() / 2) - (height / 2);

        g.fillOval(x, y, width, height);
        g.setColor(getBackground());
        g.fillOval(x + 30, y + 40, width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
