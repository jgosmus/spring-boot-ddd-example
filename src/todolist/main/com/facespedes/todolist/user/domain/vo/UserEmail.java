package com.facespedes.todolist.user.domain.vo;

import com.facespedes.todolist.shared.domain.StringValueObject;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserEmail extends StringValueObject {

    private String email;

    public UserEmail(String email) {
        Pattern pattern = Pattern.compile(".+@.+\\.[a-z]+");
        if (!pattern.matcher(email).matches())
            throw new IllegalArgumentException("Invalid email");

        this.email = email;
    }

    public String value() {
        return email;
    }

}
