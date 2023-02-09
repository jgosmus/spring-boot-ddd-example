package com.facespedes.todolist.user.domain.vo;

import com.facespedes.todolist.shared.domain.StringValueObject;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class UserEmail extends StringValueObject {

    private String email;

    public UserEmail(String email) {
        this.email = email;
    }

    @JsonValue
    public String value() {
        return email;
    }

}
