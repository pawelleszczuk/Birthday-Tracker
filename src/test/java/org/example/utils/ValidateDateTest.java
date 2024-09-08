package org.example.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateDateTest {

    @Test
    void boolean_isDateFormatValid_returnFalseWhenFormatWithSlashes() {

        //given
        String date = "1999/12/15";

        //when
        boolean result = ValidateDate.isDateFormatValid(date);

        //then
        assertFalse(result);

    }

    @Test
    void boolean_isDateFormatValid_returnFalseWhenFormatWithDots() {

        //given
        String date = "1999.12.15";

        //when
        boolean result = ValidateDate.isDateFormatValid(date);

        //then
        assertFalse(result);

    }

    @Test
    void boolean_isDateFormatValid_returnFalseWhenDateContainsLetters() {

        //given
        String date = "19ss-12-15";

        //when
        boolean result = ValidateDate.isDateFormatValid(date);

        //then
        assertFalse(result);

    }

    @Test
    void boolean_isDateFormatValid_returnTrueWhenDateAndFormatIsCorrect() {

        //given
        String date = "1999-12-15";

        //when
        boolean result = ValidateDate.isDateFormatValid(date);

        //then
        assertTrue(result);

    }

}
