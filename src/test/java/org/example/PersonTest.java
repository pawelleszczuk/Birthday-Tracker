package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Date;

import static org.example.Person.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PersonTest {

    private InputStream originalIn;
    private

    @BeforeEach
    void setUp() {
        originalIn = System.in;
    }

    @AfterEach
    void cleanUp() {
        System.setIn(originalIn);
    }

    @Test
    void String_getNamePart_shouldReturnStripString() {

        //given
        String simulatedInput = "   Jacob   \n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        //when
        String result = getNamePart("anything");

        //then
        assertEquals("Jacob", result);

    }

    @Test
    void Date_setDateOfBirth_shouldReturnNullWhenUserWritesNothing() {

        //given
        String simulatedInput = "\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        //when
        Date result = setDateOfBirth();

        //then
        assertNull(result);

    }

    @Test
    void Date_setDateOfBirth_shouldReturnNullWhenUserWritesOnlyWhiteSpaces() {

        //given
        String simulatedInput = "            \n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        //when
        Date result = setDateOfBirth();

        //then
        assertNull(result);

    }

    @Test
    void Date_setDateOfBirth_shouldReturnDateWhenUserWritesCorrectDateAndFormat() {

        //given
        String simulatedInput = "2020-01-30\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        //when
        Date result = setDateOfBirth();

        //then
        assertEquals(Date.valueOf("2020-01-30"), result);

    }

    @Test
    void Date_setDateOfBirth_shouldReturnDateWhenUserWritesCorrectDateAndFormatEvenWithWhiteSpaces() {

        //given
        String simulatedInput = "      2024-09-01      \n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        //when
        Date result = setDateOfBirth();

        //then
        assertEquals(Date.valueOf("2024-09-01"), result);

    }

    @Test
    void String_setStringField_shouldReturnNullWhenUserWritesOnlyWhiteSpaces() {

        //given
        String simulatedInput = "      \n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        //when
        String result = setStringField("anything");

        //then
        assertNull(result);

    }

    @Test
    void String_setStringField_shouldReturnStringWhenUserWritesSomethingButWhiteSpaces() {

        //given
        String simulatedInput = "   Something   \n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        //when
        String result = setStringField("anything");

        //then
        assertEquals("Something", result);

    }
}
