package org.example;

import java.sql.SQLException;

public interface DbaseOperations {
    void logIn() throws SQLException;
    void checkTodaysBirthday();
    void addPerson() throws SQLException;
    void readWithSameConditions();
    void readRecords();
    void deletePerson() throws SQLException;
    void updatePerson() throws SQLException;
}