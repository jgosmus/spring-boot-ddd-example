package com.facespedes.todolist.user.domain;

import com.facespedes.todolist.user.domain.vo.UserPassword;
import com.github.javafaker.Faker;

public class UserPasswordMother {

    public static UserPassword random() {
        return new UserPassword(Faker.instance().internet().password());
    }
}
