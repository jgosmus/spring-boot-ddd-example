package com.facespedes.todo.user.domain;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class UserPassword {
    private String password;

    public UserPassword(String password) {
        this.password = password;
    }

    public String value() {
        return password;
    }

}
