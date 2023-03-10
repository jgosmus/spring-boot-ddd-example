package com.facespedes.apps.todo.backend.controllers.task_post_controller;

import com.facespedes.todolist.task.application.use_cases.TaskCreator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@AllArgsConstructor
@RestController
public final class TaskPostController {

    private final TaskCreator taskCreator;


    @PostMapping("task")
    public void createTask(@RequestBody TaskPostRequest taskPostRequest) {
        taskCreator.create(UUID.randomUUID().toString(), taskPostRequest.description(), taskPostRequest.userId());
    }
}

record TaskPostRequest(String description, String userId) {
}
