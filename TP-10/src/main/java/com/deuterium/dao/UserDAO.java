package com.deuterium.dao;

import com.deuterium.model.User;
import com.deuterium.util.UserNotFoundException;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    // CRUD && Custom finders

    // Create

    /**
     * Add a new user to the DB
     *
     * @param fullName The new user full name
     * @param login    The new user login
     * @param password the new user password
     * @return The auto generated id from the DBMS (MySql) for the newly created user
     * @throws SQLException
     */
    int add(String fullName, String login, String password) throws SQLException;


    /**
     * Add a new user to the DB
     *
     * @param newUser
     * @return The auto generated id from the DBMS (MySql) for the newly created user
     * @throws SQLException
     */
    default int add(@NotNull User newUser) throws SQLException {
        return add(newUser.getFullName(), newUser.getLogin(), newUser.getPassword());
    }

    /**
     * Find a user by his id
     *
     * @param id - The user id
     * @return The user with the id in parameter otherwise throw a UserNotFoundException
     * @throws SQLException
     * @throws UserNotFoundException
     */
    // Read
    User getById(int id) throws SQLException, UserNotFoundException;

    /**
     * Find a user by his full name
     *
     * @param fullName
     * @return The user with the full name in parameter otherwise throw a UserNotFoundException
     * @throws SQLException
     * @throws UserNotFoundException
     */
    List<User> getByFullName(String fullName) throws SQLException, UserNotFoundException;

    /**
     * Find a user by his login name
     *
     * @param login The user login
     * @return The user with the login in parameter otherwise throw a UserNotFoundException
     * @throws SQLException
     * @throws UserNotFoundException
     */
    User getByLogin(String login) throws SQLException, UserNotFoundException;

    /**
     * Update a user
     *
     * @param userToUpdate
     * @return
     * @throws SQLException
     * @throws UserNotFoundException
     */
    // Update
    int update(User userToUpdate) throws SQLException, UserNotFoundException;


    // Delete
    int delete(int id) throws SQLException, UserNotFoundException;

    int delete(String login) throws SQLException, UserNotFoundException;
}
