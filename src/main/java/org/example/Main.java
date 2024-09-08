package org.example;

import org.example.utils.PressToContinue;
import org.example.jdbc.JdbcDatabaseManager;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        DbaseOperations dbaseOperations = new JdbcDatabaseManager();
        dbaseOperations.logIn();
        dbaseOperations.checkTodaysBirthday();

        boolean toContinue = true;
        Scanner scanner = new Scanner(System.in);

        while (toContinue) {
            System.out.println("What do you want to do?");
            System.out.println("1 - Display all people sorted by ...");
            System.out.println("2 - Add new person");
            System.out.println("3 - Update person's data");
            System.out.println("4 - Delete person");
            System.out.println("0 - Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    dbaseOperations.readRecords();
                    break;
                case "2":
                    dbaseOperations.addPerson();
                    dbaseOperations.readWithSameConditions();
                    break;
                case "3":
                    dbaseOperations.updatePerson();
                    dbaseOperations.readWithSameConditions();
                    break;
                case "4":
                    dbaseOperations.deletePerson();
                    dbaseOperations.readWithSameConditions();
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    toContinue = false;
                    break;
                default:
                    System.out.println("Incorrect choice!");
                    PressToContinue.pressToContinue();
            }
        }
        scanner.close();
    }
}