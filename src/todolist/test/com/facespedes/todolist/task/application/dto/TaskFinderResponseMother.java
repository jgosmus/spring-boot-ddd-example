package com.facespedes.todolist.task.application.dto;

import com.facespedes.todolist.task.domain.aggregate.Task;

public class TaskFinderResponseMother {
    public static TaskFinderResponse fromTask(Task task) {
        return new TaskFinderResponse(task.getId().value(), task.getDescription(), task.getStatus().name(),
                task.getUserId().value());
    }
}
