package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqlReadInstructionTest {

    private InputStream originalIn;

    @BeforeEach
    void setUp() {
        originalIn = System.in;
    }

    @AfterEach
    void cleanUp() {
        System.setIn(originalIn);
    }

    @Test
    void String_sortByColumnNamed_returnString_name_WhenUserWrites1() {

        //given
        String simulatedInput = "1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        //when
        String result = SqlReadInstruction.sortByColumnNamed();

        //then
        assertEquals("name", result);

    }

    @Test
    void String_sortByColumnNamed_returnString_lastName_WhenUserWrites2() {

        //given
        String simulatedInput = "2\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        //when
        String result = SqlReadInstruction.sortByColumnNamed();

        //then
        assertEquals("lastName", result);

    }

    @Test
    void String_sortByColumnNamed_returnString_dateOfBirth_WhenUserWrites3() {

        //given
        String simulatedInput = "3\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        //when
        String result = SqlReadInstruction.sortByColumnNamed();

        //then
        assertEquals("dateOfBirth", result);

    }
}
