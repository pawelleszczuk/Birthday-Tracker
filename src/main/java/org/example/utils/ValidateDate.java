package org.example.utils;

import org.apache.commons.validator.GenericValidator;

public class ValidateDate {
    public static boolean isDateFormatValid(String date) {
        if (GenericValidator.isDate(date, "yyyy-MM-dd", true)) {
            return true;
        }
        System.out.println("Incorrect date format!");
        return false;
    }
}