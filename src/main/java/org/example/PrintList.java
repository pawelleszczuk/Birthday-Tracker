package org.example;

import org.example.utils.PressToContinue;

import java.util.List;
import java.util.Objects;

public class PrintList {
    public static void printList(List<Person> people) {

        if (people.isEmpty()) {
            System.out.println("----- no data to display -----");
        } else {
            System.out.println("No. | Name | Last name | Date of birth | E-mail | Phone number | Gift | Wishes");
            for (Person person : people) {
                System.out.println(person.ordinalNumber + " | " + display(person.getName()) + " | " +
                        display(person.getLastName()) + " | " + display(String.valueOf(person.getDateOfBirth())) + " | " +
                        display(person.getEmail()) + " | " + display(person.getPhoneNumber()) + " | " +
                        display(person.getGift()) + " | " + display(person.getWishes()));
            }
        }

        System.out.println();
        PressToContinue.pressToContinue();
    }

    public static String display(String field) {
        int charsToBeDisplayed = 50;

        if ((Objects.isNull(field)) || (field.equals("null"))) {
            return "-";
        }

        if (field.length() > charsToBeDisplayed) {
            return (field.substring(0, charsToBeDisplayed - 3) + "...");
        } else {
            return field;
        }
    }
}