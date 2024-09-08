package org.example.utils;

import org.example.SqlReadInstruction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetColumnNameTest {

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
    void String_getColumnName_returnString_name_WhenUserWrites1() {

        //given
        String simulatedInput = "1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        //when
        String result = GetColumnName.getColumnName();

        //then
        assertEquals("name", result);

    }

    @Test
    void String_getColumnName_returnString_wishes_WhenUserWrites7() {

        //given
        String simulatedInput = "7\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        //when
        String result = GetColumnName.getColumnName();

        //then
        assertEquals("wishes", result);

    }
}
