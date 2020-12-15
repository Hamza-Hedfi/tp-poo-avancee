package com.deuterium;

import com.deuterium.controller.UserController;

public class TP10 {
    public static void main(String[] args) {
       /* UserDAO userDAO = new UserDAOImplJDBC();

        try {

            User newUser = new User("Hamza Hadfi", "Deuterium", "Strong pwd");

            // System.out.println(userDAO.addUser("Hamza Hadfi", "deuterium", "strongPWD"));
            // System.out.println(userDAO.addUser(newUser));
            // System.out.println(userDAO.addUser("Hamza Hadfi", "deuti", "strongPWD"));
            // System.out.println(userDAO.addUser("Hamza Hadfi", "dddddfqsd", "strongPWD"));
            // System.out.println(userDAO.getUserById(1000));
            // System.out.println(userDAO.getUserByFullName("Hamza Hadfi"));
            System.out.println(userDAO.delete("dddd"));
        } catch (Exception exception) {
            ExceptionHandler.handleException(exception);
        }*/
        // SwingUtilities.invokeLater(UserView::new);

        new UserController();

    }
}
