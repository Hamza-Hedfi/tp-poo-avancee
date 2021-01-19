package com.deuterium;

import javax.swing.*;
import java.io.IOException;

public class TP08 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new MainFrame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
