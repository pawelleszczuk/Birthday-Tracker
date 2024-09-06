package org.example.Utils;

import java.util.Scanner;

public class GetColumnName {
    public static String getColumnName() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What do you want to change?");
            System.out.println("1 - Name");
            System.out.println("2 - Last name");
            System.out.println("3 - Date of birth");
            System.out.println("4 - E-mail address");
            System.out.println("5 - Phone number");
            System.out.println("6 - Planned gift");
            System.out.println("7 - Planned wishes");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    return "name";
                case "2":
                    return "lastName";
                case "3":
                    return "dateOfBirth";
                case "4":
                    return "email";
                case "5":
                    return "phoneNumber";
                case "6":
                    return "gift";
                case "7":
                    return "wishes";
                default:
                    System.out.println("Incorrect choice!");
                    PressToContinue.pressToContinue();
            }
        }
    }
}