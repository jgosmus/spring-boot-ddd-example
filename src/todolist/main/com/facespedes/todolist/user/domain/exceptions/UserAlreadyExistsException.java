package com.facespedes.todolist.user.domain.exceptions;

import com.facespedes.todolist.shared.domain.AlreadyExistsException;

public class UserAlreadyExistsException extends AlreadyExistsException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
