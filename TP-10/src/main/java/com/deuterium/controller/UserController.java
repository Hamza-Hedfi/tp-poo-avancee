package com.deuterium.controller;

import com.deuterium.dao.UserDAO;
import com.deuterium.dao.UserDAOImplJDBC;
import com.deuterium.gui.UserView;
import com.deuterium.model.User;
import com.deuterium.util.ExceptionHandler;

import javax.swing.*;


/**
 * UserController class
 * As the name suggests it is a controller.
 * It will handle interaction between the UserView and UserDAO.
 * The UserDAO is responsible for accessing the data base. It has an implementation using JDBC.
 * The UserView is responsible for the IHM, or the interface.
 */
public class UserController {
    private UserDAO userDAO;
    private UserView userView;

    public UserController() {

        userView = new UserView();
        userDAO = new UserDAOImplJDBC();

        userView.setVisible(true);

        userView.saveButton.addActionListener(actionEvent -> {
            String fullName = userView.fullNameTField.getText();
            String login = userView.loginTField.getText();
            String pwd = userView.pwdTField.getText();

            User newUser = new User(fullName, login, pwd);

            try {
                int id = userDAO.add(newUser);
                JOptionPane.showMessageDialog(userView, "The user was successfully added with ID: " + id, "User Added", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(userView, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ExceptionHandler.handleException(ex);
            }
        });
    }


}
