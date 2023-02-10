package com.facespedes.todolist.user.domain.exceptions;

import com.facespedes.todolist.shared.domain.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
