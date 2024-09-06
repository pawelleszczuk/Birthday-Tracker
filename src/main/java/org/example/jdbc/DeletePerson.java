package org.example.jdbc;

import org.example.Utils.GetIdPkFromOrdNumber;
import org.example.Utils.PressToContinue;

import java.sql.SQLException;

public class DeletePerson {
    public static void deletePerson (JdbcDatabaseManager jdbcDatabaseManager) throws SQLException {
        int idPkToBeDeleted = GetIdPkFromOrdNumber.getPkId();

        if (idPkToBeDeleted != 0) {
            String sqlDelete = "DELETE FROM person WHERE id = " + idPkToBeDeleted;
            jdbcDatabaseManager.statement.executeUpdate(sqlDelete);
            System.out.println("Person deleted!");
            PressToContinue.pressToContinue();
        }
    }
}