package com.facespedes.apps.todolist.backend.controllers.task_post_controller;

import com.facespedes.todolist.task.application.use_cases.TaskCreator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public final class TaskPostController {

    private final TaskCreator taskCreator;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("task")
    public void createTask(@RequestBody TaskPostRequest taskPostRequest) {
        taskCreator.create(taskPostRequest.id(), taskPostRequest.description(), taskPostRequest.userId());
    }
}

record TaskPostRequest(String id, String description, String userId) {
}
