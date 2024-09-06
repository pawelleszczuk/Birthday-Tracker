package org.example.Utils;

import java.util.Objects;

public class FieldToCommit {
    public static String fieldToCommit(String field) {
        if (Objects.isNull(field) || field.equals("null")) {
            return null;
        }
        return ("'" + field + "'");
    }
}