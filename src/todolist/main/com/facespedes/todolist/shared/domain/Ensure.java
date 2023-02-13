package com.facespedes.todolist.shared.domain;

public class Ensure {

    private Ensure() {
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
