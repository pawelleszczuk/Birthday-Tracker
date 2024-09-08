package org.example.utils;

import java.util.Scanner;

public class PressToContinue {
    public static void pressToContinue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to continue");
        scanner.nextLine();
        System.out.println();
    }
}
