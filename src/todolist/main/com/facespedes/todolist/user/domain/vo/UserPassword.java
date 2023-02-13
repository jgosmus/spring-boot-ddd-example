package com.facespedes.todolist.user.domain.vo;

import com.facespedes.todolist.shared.domain.StringValueObject;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserPassword extends StringValueObject {

    private String password;

    public UserPassword(String password) {
        Objects.requireNonNull(password);
        if (password.length() < 8 || password.length() > 20)
            throw new IllegalArgumentException("Invalid password");
        this.password = password;
    }

    public String value() {
        return password;
    }

}
