package org.example;

import org.example.utils.PressToContinue;

import java.util.Scanner;

import static org.example.GlobalVariables.sqlReadInstruction;

public class SqlReadInstruction {

    public static String sqlReadInstruction() {
        String sortByColumnNamed = sortByColumnNamed();
        String sortAscOrDesc = sortAscOrDesc();

        sqlReadInstruction = "SELECT * FROM person ORDER BY " + sortByColumnNamed + " " + sortAscOrDesc;

        return sqlReadInstruction;
    }

    static String sortByColumnNamed() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        while (true) {
            System.out.println("Sorted by: ");
            System.out.println("1 - Name");
            System.out.println("2 - Lastname");
            System.out.println("3 - Date of birth");

            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    return "name";
                case "2":
                    return "lastName";
                case "3":
                    return "dateOfBirth";
                default:
                    System.out.println("Incorrect choice!");
                    PressToContinue.pressToContinue();
            }
        }
    }

    static String sortAscOrDesc() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        while (true) {
            System.out.println("Ascending or descending?");
            System.out.println("1 - Ascending");
            System.out.println("2 - Descending");

            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    return "ASC";
                case "2":
                    return "DESC";
                default:
                    System.out.println("Incorrect choice!");
                    PressToContinue.pressToContinue();
            }
        }
    }
}