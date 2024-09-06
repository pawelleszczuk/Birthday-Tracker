package org.example.jdbc;

import org.example.Person;
import org.example.Utils.FieldToCommit;
import org.example.Utils.PressToContinue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class AddPerson {
    public static void addPerson(JdbcDatabaseManager jdbcDatabaseManager) throws SQLException {
        String sqlRequest;
        Person person = new Person();

        String dateOfBirth = FieldToCommit.fieldToCommit(String.valueOf(person.getDateOfBirth()));
        String email = FieldToCommit.fieldToCommit(person.getEmail());
        String phoneNumber = FieldToCommit.fieldToCommit(person.getPhoneNumber());

        if (!isDuplicate(jdbcDatabaseManager, person)) {
            sqlRequest = "INSERT INTO person(name, lastName, dateOfBirth, email, phoneNumber) " +
                    "VALUES('" + person.getName() + "', '" + person.getLastName() + "', " + dateOfBirth +
                    ", " + email + ", " + phoneNumber + ")";

            jdbcDatabaseManager.statement.executeUpdate(sqlRequest);
            System.out.println("Person added succesfully!");
            PressToContinue.pressToContinue();
        } else {
            System.out.println("This person already exists!");
            PressToContinue.pressToContinue();
        }
    }


    private static boolean isDuplicate(JdbcDatabaseManager jdbcDatabaseManager, Person personToAdd) throws SQLException {
        String name = personToAdd.getName();
        String lastName = personToAdd.getLastName();
        String dateOfBirth = FieldToCommit.fieldToCommit(String.valueOf(personToAdd.getDateOfBirth()));
        String sql;

        if (Objects.isNull(dateOfBirth) || dateOfBirth.equals("null")) {
            sql = "SELECT * FROM person " +
                    "WHERE name = '" + name + "' AND lastName = '" + lastName + "' " +
                    "LIMIT 1";
        } else {
            sql = "SELECT * FROM person " +
                    "WHERE name = '" + name + "' AND lastName = '" + lastName + "' AND dateOfBirth = " + dateOfBirth +
                    " LIMIT 1";
        }

        ResultSet resultSet = jdbcDatabaseManager.statement.executeQuery(sql);

        return resultSet.next();
    }
}