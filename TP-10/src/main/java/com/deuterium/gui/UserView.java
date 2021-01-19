package com.deuterium.gui;

import javax.swing.*;

public class UserView extends JFrame {
    public JTextField fullNameTField;
    public JTextField loginTField;
    public JTextField pwdTField;
    public JButton saveButton;
    private JPanel panel;
    private JLabel fullNameLabel;
    private JLabel loginLabel;
    private JLabel pwdLabel;

    public UserView() {
        super("Add User");

        panel = new JPanel();

        fullNameLabel = new JLabel("Full Name: ");
        loginLabel = new JLabel("Login: ");
        pwdLabel = new JLabel("Password: ");

        fullNameTField = new JTextField(10);
        loginTField = new JTextField(10);
        pwdTField = new JTextField(10);

        saveButton = new JButton("Add User");

        panel.add(fullNameLabel);
        panel.add(fullNameTField);
        panel.add(loginLabel);
        panel.add(loginTField);
        panel.add(pwdLabel);
        panel.add(pwdTField);
        panel.add(saveButton);

        add(panel);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

}
