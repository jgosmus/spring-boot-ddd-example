package com.facespedes.apps.todo.backend.controllers.task_get_controller;

import com.facespedes.todolist.task.application.dto.TaskFinderResponse;
import com.facespedes.todolist.task.application.use_cases.TaskFinder;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public final class TaskGetController {

    private final TaskFinder taskFinder;


    @GetMapping("task/{id}")
    public TaskFinderResponse getTask(@PathVariable String id) {
        return taskFinder.findById(id);
    }
}
