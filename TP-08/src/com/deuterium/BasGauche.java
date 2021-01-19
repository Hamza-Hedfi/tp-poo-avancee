package com.deuterium;

import javax.swing.*;
import java.awt.*;

public class BasGauche extends JPanel {
    public BasGauche() {
        setBorder(BorderFactory.createTitledBorder("Plain Text"));
        setLayout(new BorderLayout());
        JTextArea jTextArea = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
//        jTextArea.setWrapStyleWord(true);
        jTextArea.setLineWrap(true);

        add(new JScrollPane(jTextArea), BorderLayout.CENTER);

    }
}
