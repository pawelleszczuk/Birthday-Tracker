package org.example.utils;

import org.junit.jupiter.api.Test;

import static org.example.utils.FieldToCommit.fieldToCommit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FieldToCommitTest {

    @Test
    void String_fieldToCommit_shouldReturnNullWhenArgumentIsNull() {

        //given
        String string = null;

        //when
        String result = fieldToCommit(string);

        //then
        assertNull(result);

    }

    @Test
    void String_fieldToCommit_shouldReturnNullWhenArgumentIsStringWithNullContent() {

        //given
        String string = "null";

        //when
        String result = fieldToCommit(string);

        //then
        assertNull(result);

    }

    @Test
    void String_fieldToCommit_shouldReturnStringInApostrophesWhenArgumentIsNotNullOrItsContentIsNotNull() {

        //given
        String string = "Gregory";

        //when
        String result = fieldToCommit(string);

        //then
        assertEquals("'Gregory'", result);

    }
}
