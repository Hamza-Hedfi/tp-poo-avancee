package com.deuterium.dao;

import com.deuterium.model.User;
import com.deuterium.util.UserNotFoundException;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    // CRUD && Custom finders

    // Create
    int add(String fullName, String login, String password) throws SQLException;

    default int add(@NotNull User newUser) throws SQLException {
        return add(newUser.getFullName(), newUser.getLogin(), newUser.getPassword());
    }

    // Read
    User getById(int id) throws SQLException, UserNotFoundException;

    List<User> getByFullName(String fullName) throws SQLException, UserNotFoundException;

    User getByLogin(String login) throws SQLException, UserNotFoundException;

    // Update
    int update(User userToUpdate) throws SQLException, UserNotFoundException;


    // Delete
    int delete(int id) throws SQLException, UserNotFoundException;

    int delete(String login) throws SQLException, UserNotFoundException;
}
