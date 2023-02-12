package com.facespedes.apps.todo.backend.controllers.user_get_controller;

import com.facespedes.todolist.user.application.dto.UserFinderResponse;
import com.facespedes.todolist.user.application.use_cases.UserFinder;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public final class UserGetController {

    private final UserFinder userFinder;


    @GetMapping("user/{id}")
    public UserFinderResponse getUser(@PathVariable String id) {
        return userFinder.findUser(id);
    }
}
