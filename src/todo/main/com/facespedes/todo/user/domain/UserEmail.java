package com.facespedes.todo.user.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class UserEmail {
    @JsonValue
    private String email;

    public UserEmail(String email) {
        this.email = email;
    }

    @JsonValue
    public String value() {
        return email;
    }

}
