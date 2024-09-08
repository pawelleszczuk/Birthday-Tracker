package org.example.jdbc;

import org.example.DbaseOperations;
import org.example.GlobalVariables;
import org.example.SqlReadInstruction;

import java.sql.*;
import java.util.*;

public class JdbcDatabaseManager implements DbaseOperations {
    static Scanner scanner = new Scanner(System.in);
    String user;
    String password;
    final String url = "jdbc:mysql://127.0.0.1:3306/birthday";
    Statement statement;

    public JdbcDatabaseManager() {
        System.out.println("Log in");
        this.user = enterUsername();
        this.password = enterPassword();
    }

    public String enterUsername() {
        System.out.println("Enter user name: ");
        user = scanner.nextLine();
        return user;
    }

    public String enterPassword() {
        System.out.println("Enter user password: ");
        password = scanner.nextLine();
        return password;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    String getUsername() {
        return user;
    }

    String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public void logIn() throws SQLException {
        LogIn.logIn(this);
    }

    @Override
    public void checkTodaysBirthday() {
        CheckTodaysBirthday.checkTodaysBirthday(this);
    }

    @Override
    public void readRecords() {
        GlobalVariables.sqlReadInstruction = SqlReadInstruction.sqlReadInstruction();
        ReadRecords.readRecords(this, GlobalVariables.sqlReadInstruction);
    }

    @Override
    public void readWithSameConditions() {
        ReadRecords.readRecords(this, GlobalVariables.sqlReadInstruction);
    }

    @Override
    public void addPerson() throws SQLException {
        AddPerson.addPerson(this);
    }

    @Override
    public void deletePerson() throws SQLException {
        DeletePerson.deletePerson(this);
    }

    @Override
    public void updatePerson() throws SQLException {
        UpdatePerson.updatePerson(this);
    }
}