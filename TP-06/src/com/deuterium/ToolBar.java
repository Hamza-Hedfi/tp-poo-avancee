package com.deuterium;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel implements ActionListener {
    private final ButtonGroup buttonGroup;
    private final JRadioButton luneRadioButton;
    private final JRadioButton soleilRadioButton;
    private final JRadioButton croissantRadioButton;

    private DrawListener drawListener;

    public ToolBar() {
        buttonGroup = new ButtonGroup();
        luneRadioButton = new JRadioButton("Lune");
        soleilRadioButton = new JRadioButton("Soleil");
        croissantRadioButton = new JRadioButton("Croissant");

        luneRadioButton.addActionListener(this);
        soleilRadioButton.addActionListener(this);
        croissantRadioButton.addActionListener(this);

        buttonGroup.add(luneRadioButton);
        buttonGroup.add(soleilRadioButton);
        buttonGroup.add(croissantRadioButton);

        add(luneRadioButton);
        add(soleilRadioButton);
        add(croissantRadioButton);
    }

    public void setDrawListener(DrawListener drawListener) {
        this.drawListener = drawListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton selected = (JRadioButton) e.getSource();
        if (selected == luneRadioButton) {
            if (drawListener != null) {
                drawListener.drawLune();
            }
        }
        if (selected == soleilRadioButton) {
            if (drawListener != null) {
                drawListener.drawSoleil();
            }
        }
        if (selected == croissantRadioButton) {
            if (drawListener != null) {
                drawListener.drawCroissant();
            }
        }
    }
}
