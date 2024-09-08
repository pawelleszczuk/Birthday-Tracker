package org.example;

import org.example.utils.ValidateDate;

import java.sql.Date;
import java.util.Scanner;

public class Person {
    int ordinalNumber;
    int id;
    private final String name;
    private final String lastName;
    private final Date dateOfBirth;
    private final String email;
    private final String phoneNumber;
    private String gift;
    private String wishes;

    public Person() {
        this.name = setName();
        this.lastName = setLastName();
        this.dateOfBirth = setDateOfBirth();
        this.email = setEmail();
        this.phoneNumber = setPhoneNumber();
    }

    public Person(int ordinalNumber, int id, String name, String lastName, Date dateOfBirth, String email, String phoneNumber, String gift, String wishes) {
        this.ordinalNumber = ordinalNumber;
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gift = gift;
        this.wishes = wishes;
    }

    public int getId() {
        return id;
    }

    public int getOrdinalNumber() {
        return ordinalNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGift() {
        return gift;
    }

    public String getWishes() {
        return wishes;
    }

    private static String setName() {
        return getNamePart("name");
    }

    private static String setLastName() {
        return getNamePart("lastname");
    }

    private static String setEmail() {
        return setStringField("e-mail");
    }

    private static String setPhoneNumber() {
        return setStringField("phone number");
    }


    static String getNamePart(String string) {
        String result;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter the " + string + " (mandatory field): ");
            result = scanner.nextLine().strip();

            if (result.isBlank()) {
                System.out.println("This field cannot be empty!");
            }
        } while (result.isBlank());

        return result;
    }

    static Date setDateOfBirth() {
        String date;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter the date of birth in YYYY-MM-DD format (you can complete it later - then leave empty field): ");
            date = scanner.nextLine().strip();
            if (date.isBlank()) return null;
        } while (!ValidateDate.isDateFormatValid(date));

        return Date.valueOf(date);
    }

    static String setStringField(String fieldName) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter person's " + fieldName + " (you can complete it later - then leave empty field): ");
        String field = scanner.nextLine().strip();

        if (field.isBlank()) {
            return null;
        } else {
            return field;
        }
    }
}