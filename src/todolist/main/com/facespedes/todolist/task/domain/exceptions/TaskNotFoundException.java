package com.facespedes.todolist.task.domain.exceptions;

import com.facespedes.todolist.shared.domain.NotFoundException;

public class TaskNotFoundException extends NotFoundException {
    public TaskNotFoundException(String message) {
        super(message);
    }
}
