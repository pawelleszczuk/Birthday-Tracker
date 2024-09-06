package org.example.jdbc;

import org.example.Person;
import org.example.PrintList;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.GlobalVariables.people;

public class ReadRecords {
    public static void readRecords(JdbcDatabaseManager jdbcDatabaseManager, String sqlRead) {

        people.clear();
        try {
            ResultSet resultSet = jdbcDatabaseManager.statement.executeQuery(sqlRead);
            int ordinalNumber = 1;
            while (resultSet.next()) {
                Person person = new Person(ordinalNumber++, resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("lastName"), resultSet.getDate("dateOfBirth"),
                        resultSet.getString("email"), resultSet.getString("phoneNumber"),
                        resultSet.getString("gift"), resultSet.getString("wishes"));
                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        PrintList.printList(people);
    }
}