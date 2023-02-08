package com.facespedes.todolist.user.domain.vo;

import com.facespedes.todolist.shared.domain.StringValueObject;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class UserPassword extends StringValueObject {
    private String password;

    public UserPassword(String password) {
        this.password = password;
    }

    public String value() {
        return password;
    }

}
