package com.facespedes.todolist.user.domain;

import com.facespedes.todolist.user.domain.vo.UserEmail;
import com.github.javafaker.Faker;

public class UserEmailMother {

    public static UserEmail random() {
        return new UserEmail(Faker.instance().internet().emailAddress());
    }
}
