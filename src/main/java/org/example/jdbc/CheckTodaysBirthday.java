package org.example.jdbc;

import org.example.GlobalVariables;

import java.time.LocalDate;

public class CheckTodaysBirthday {
    public static void checkTodaysBirthday(JdbcDatabaseManager jdbcDatabaseManager) {
        LocalDate dateNow = LocalDate.now();
        int monthValueNow = dateNow.getMonthValue();
        int dayOfMonthNow = dateNow.getDayOfMonth();

        String sqlReadTodaysBirthday = "SELECT * FROM person " +
                "WHERE MONTH(dateOfBirth) = " + monthValueNow + " AND DAY(dateOfBirth) = " + dayOfMonthNow + ";";

        System.out.println("Today is the birthday of: ");
        ReadRecords.readRecords(jdbcDatabaseManager, sqlReadTodaysBirthday);

        readAllDefault(jdbcDatabaseManager);
    }

    private static void readAllDefault(JdbcDatabaseManager jdbcDatabaseManager) {
        String defaultOrder = "ORDER BY lastName ASC";
        GlobalVariables.sqlReadInstruction = "SELECT * FROM person " + defaultOrder;
        ReadRecords.readRecords(jdbcDatabaseManager, GlobalVariables.sqlReadInstruction);
    }
}