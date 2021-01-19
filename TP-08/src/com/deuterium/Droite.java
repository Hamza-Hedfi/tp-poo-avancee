package com.deuterium;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Droite extends JPanel {
    public Droite() throws IOException {
        setBorder(BorderFactory.createTitledBorder("Styled Text"));

        setLayout(new BorderLayout());

        JEditorPane jEditorPane = new JEditorPane("https://en.wikipedia.org/wiki/Swing_(Java)");
        jEditorPane.setSize(300, 300);

        JTextPane jTextPane = new JTextPane();

        add(new JScrollPane(jEditorPane), BorderLayout.NORTH);
        add(jTextPane, BorderLayout.SOUTH);
    }
}
