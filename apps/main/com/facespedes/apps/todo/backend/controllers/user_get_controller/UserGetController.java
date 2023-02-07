package com.facespedes.apps.todo.backend.controllers.user_get_controller;

import com.facespedes.todo.user.application.UserFinder;
import com.facespedes.todo.user.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserGetController {

    private final UserFinder userFinder;

    @GetMapping("user")
    public User getUser() {
        return userFinder.findUser("1cabe8de-9e38-4b7f-b897-f11bfc6d4cdc");
    }
}
