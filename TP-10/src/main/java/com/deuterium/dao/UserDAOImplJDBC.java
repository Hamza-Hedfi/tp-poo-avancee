package com.deuterium.dao;

import com.deuterium.model.User;
import com.deuterium.util.ConnectionPool;
import com.deuterium.util.UserNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImplJDBC implements UserDAO {

    @Override
    public int add(String fullName, String login, String password) throws SQLException {
        String query = "INSERT INTO user (fullname, login, pwd) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, password);

            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys();) {
                int autogenkey = 0;

                if (resultSet.next()) {
                    autogenkey = resultSet.getInt(1);
                }
                return autogenkey;
            }
        }
    }

    @Override
    public User getById(int id) throws SQLException, UserNotFoundException {
        String query = "SELECT * FROM user WHERE id = ?";

        try (Connection connection = ConnectionPool.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next()) throw new UserNotFoundException("User with id: " + id + " doesn't exist");
                else {
                    User u = new User();
                    while (resultSet.next()) {
                        u.setId(resultSet.getInt("id"));
                        u.setFullName(resultSet.getString("fullname"));
                        u.setLogin(resultSet.getString("login"));
                        u.setPassword(resultSet.getString("pwd"));
                    }
                    return u;
                }
            }
        }
    }

    @Override
    public List<User> getByFullName(String fullName) throws SQLException, UserNotFoundException {
        String query = "SELECT * FROM user WHERE fullname = ?";

        try (Connection connection = ConnectionPool.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, fullName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next())
                    throw new UserNotFoundException("User with name: " + fullName + " doesn't exist");
                else {
                    User u = new User();
                    List<User> userList = new ArrayList<>();
                    while (resultSet.next()) {
                        u.setId(resultSet.getInt("id"));
                        u.setFullName(resultSet.getString("fullname"));
                        u.setLogin(resultSet.getString("login"));
                        u.setPassword(resultSet.getString("pwd"));
                        userList.add(u);
                    }
                    return userList;
                }
            }
        }
    }

    @Override
    public User getByLogin(String login) throws SQLException, UserNotFoundException {
        String query = "SELECT * FROM user WHERE login = ?";

        try (Connection connection = ConnectionPool.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next()) throw new UserNotFoundException("User with login: " + login + " doesn't exist");
                else {
                    User u = new User();
                    while (resultSet.next()) {
                        u.setId(resultSet.getInt("id"));
                        u.setFullName(resultSet.getString("fullname"));
                        u.setLogin(resultSet.getString("login"));
                        u.setPassword(resultSet.getString("pwd"));
                    }
                    return u;
                }
            }
        }
    }

    @Override
    public int update(User userToUpdate) throws SQLException, UserNotFoundException {
        String query = "UPDATE user SET fullname = ?, login = ?, pwd = ? WHERE id = ?";

        try (Connection connection = ConnectionPool.getConnection();) {

            // Just check if the user exists
            getById(userToUpdate.getId());

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userToUpdate.getFullName());
            preparedStatement.setString(2, userToUpdate.getLogin());
            preparedStatement.setString(3, userToUpdate.getPassword());
            preparedStatement.setInt(4, userToUpdate.getId());

            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public int delete(int id) throws SQLException, UserNotFoundException {
        String query = "DELETE FROM user WHERE id = ?";

        try (Connection connection = ConnectionPool.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            int deletedCount = preparedStatement.executeUpdate();
            if (deletedCount == 0) throw new UserNotFoundException("User with id: " + id + " doesn't exist");
            return deletedCount;
        }
    }

    @Override
    public int delete(String login) throws SQLException, UserNotFoundException {
        String query = "DELETE FROM user WHERE login = ?";

        try (Connection connection = ConnectionPool.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);

            int deletedCount = preparedStatement.executeUpdate();
            if (deletedCount == 0) throw new UserNotFoundException("User with login: " + login + " doesn't exist");
            return deletedCount;

        }
    }
}
