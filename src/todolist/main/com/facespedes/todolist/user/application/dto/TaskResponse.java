package com.facespedes.todolist.user.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TaskResponse {
    private String id;
    private String description;
    private String status;
}
