package com.facespedes.todolist.user.application.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
public final class UserTasksFinderResponse {
    private String id;
    private String email;
    private List<TaskResponse> tasks;
}
