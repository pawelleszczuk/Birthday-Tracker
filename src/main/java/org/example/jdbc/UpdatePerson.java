package org.example.jdbc;

import org.example.utils.GetColumnName;
import org.example.utils.GetIdPkFromOrdNumber;
import org.example.utils.PressToContinue;
import org.example.utils.ValidateDate;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdatePerson {
    public static void updatePerson (JdbcDatabaseManager jdbcDatabaseManager) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int idPk = GetIdPkFromOrdNumber.getPkId();
        String newValue = "";

        if (idPk != 0) {
            String columnToUpdate = GetColumnName.getColumnName();

            while (newValue.isBlank()) {
                System.out.println("Enter new content for field " + columnToUpdate + " (date in format yyyy-MM-dd): ");
                newValue = scanner.nextLine().strip();

                if (newValue.isBlank()) {
                    System.out.println("Field cannot be empty!");
                } else if (!columnToUpdate.equals("dateOfBirth")) {
                    break;
                } else if (ValidateDate.isDateFormatValid(newValue)) {
                    break;
                } else {
                    newValue = "";
                }
            }

            String sqlUpdate = "UPDATE person " +
                    "SET " + columnToUpdate + " = '" + newValue + "' " +
                    "WHERE id =" + idPk;

            jdbcDatabaseManager.statement.executeUpdate(sqlUpdate);

            System.out.println("Update completed!");
            PressToContinue.pressToContinue();
        }
    }
}