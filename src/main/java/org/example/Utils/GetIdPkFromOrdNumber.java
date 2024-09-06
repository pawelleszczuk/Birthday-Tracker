package org.example.Utils;

import org.example.Person;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.example.GlobalVariables.people;

public class GetIdPkFromOrdNumber {
    public static int getPkId() {
        int idPkToBeDeleted = 0;

        int ordinalNumber = getOrdinalNumber();

        if (ordinalNumber != 0) {
            idPkToBeDeleted = getIdPrimaryKey(ordinalNumber);
        }

        return idPkToBeDeleted;
    }


    private static int getOrdinalNumber() {
        int numberNo = -1;
        Scanner scanner = new Scanner(System.in);

        while (numberNo < 0 || numberNo > people.size()) {
            System.out.println("Enter the No. of the person (1-" + people.size() +
                    ") or 0 to get back");
            try {
                numberNo = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("It is not an integer!");
                scanner.nextLine();
                continue;
            }

            if (numberNo < 0 || numberNo > people.size()) {
                System.out.println("This is not an integer in the range (0-" + people.size() + ")");
            }
        }

        return numberNo;
    }

    private static int getIdPrimaryKey(int ordinalNumber) {
        for (Person person : people) {
            if (person.getOrdinalNumber() == ordinalNumber) {
                return person.getId();
            }
        }
        return 0;
    }
}