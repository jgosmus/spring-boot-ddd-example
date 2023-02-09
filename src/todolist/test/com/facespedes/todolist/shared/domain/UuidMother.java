package com.facespedes.todolist.shared.domain;

public class UuidMother {
    public static String random() {
        return java.util.UUID.randomUUID().toString();
    }
}
