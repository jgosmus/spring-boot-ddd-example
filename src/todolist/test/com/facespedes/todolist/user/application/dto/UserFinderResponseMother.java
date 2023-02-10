package com.facespedes.todolist.user.application.dto;

import com.facespedes.todolist.user.domain.aggregate.User;

public class UserFinderResponseMother {
    public static UserFinderResponse fromUser(User user) {
        return new UserFinderResponse(user.getId().value(), user.getEmail());
    }
}
