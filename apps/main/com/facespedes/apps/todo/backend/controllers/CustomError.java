package com.facespedes.apps.todo.backend.controllers;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomError {
    private String message;
    private int httpCode;
    private Object timestamp;
}
