package com.facespedes.todolist.user.domain.vo;

import com.facespedes.todolist.shared.domain.Ensure;
import com.facespedes.todolist.shared.domain.StringValueObject;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserPassword extends StringValueObject {

    private String password;


    public UserPassword(String password) {
        Ensure.notNull(password, "Password is required");
        if (password.length() < 8 || password.length() > 20)
            throw new IllegalArgumentException("Invalid password");
        this.password = password;
    }

    public String value() {
        return password;
    }

}
