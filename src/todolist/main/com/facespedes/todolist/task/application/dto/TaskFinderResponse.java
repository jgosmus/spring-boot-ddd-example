package com.facespedes.todolist.task.application.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
public class TaskFinderResponse {
    private String id;
    private String description;
    private String status;
    private String userId;
}
