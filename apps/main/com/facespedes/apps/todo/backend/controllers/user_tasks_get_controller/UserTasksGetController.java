package com.facespedes.apps.todo.backend.controllers.user_tasks_get_controller;

import com.facespedes.todolist.user.application.dto.UserTasksFinderResponse;
import com.facespedes.todolist.user.application.use_cases.UserTasksFinder;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public final class UserTasksGetController {

    private final UserTasksFinder userFinder;


    @GetMapping("user/{id}/tasks")
    public UserTasksFinderResponse getUserWithTasks(@PathVariable String id) {
        return userFinder.findUserWithTasks(id);
    }
}
