package com.facespedes.todolist.user.domain;

import com.facespedes.todolist.user.domain.aggregate.User;

public class UserMother {

    public static User random() {
        return User.create(UserIdMother.random(), UserEmailMother.random(), UserPasswordMother.random());
    }
}
