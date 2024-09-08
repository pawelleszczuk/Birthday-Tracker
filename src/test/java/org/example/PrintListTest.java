package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrintListTest {

    @Test
    void String_display_returnMinusCharIfStringArgumentIsNull() {

        //given
        String nullString = null;

        //when
        String result = PrintList.display(nullString);

        //then
        assertEquals("-", result);

    }

    @Test
    void String_display_returnMinusCharIfStringIsTextNull() {

        //given
        String nullText = "null";

        //when
        String result = PrintList.display(nullText);

        //then
        assertEquals("-", result);

    }

    @Test
    void String_display_returnStringWith50CharsIfArgumentStringIsLonger() {

        //given
        String string = "1234567890123456789012345678901234567890123456789012345678901234567890"; //70 chars

        //when
        String result = PrintList.display(string);

        //then
        assertTrue(result.length() == 50);

    }
}
