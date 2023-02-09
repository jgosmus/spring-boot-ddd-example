package com.facespedes.todolist.user.domain;

import com.facespedes.todolist.shared.domain.UserId;
import com.facespedes.todolist.shared.domain.UuidMother;

public class UserIdMother {

    public static UserId random() {
        return new UserId(UuidMother.random());
    }
}
