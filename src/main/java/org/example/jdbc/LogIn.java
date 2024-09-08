package org.example.jdbc;

import org.example.utils.PressToContinue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LogIn {
    public static void logIn(JdbcDatabaseManager jdbcDatabaseManager) throws SQLException {
        boolean isLogged = false;
        Connection connection = null;

        while (!isLogged) {
            try {
                System.out.println("Verifying...");
                connection = DriverManager.getConnection(jdbcDatabaseManager.getUrl(),
                        jdbcDatabaseManager.getUsername(), jdbcDatabaseManager.getPassword());
                isLogged = true;
            } catch (SQLException e) {
                System.out.println("Incorrect username and/or password - please try again: ");
                jdbcDatabaseManager.enterUsername();
                jdbcDatabaseManager.enterPassword();
            }
        }

        jdbcDatabaseManager.setStatement(connection.createStatement());
        System.out.println("Logged succesfully!");
        PressToContinue.pressToContinue();
    }
}