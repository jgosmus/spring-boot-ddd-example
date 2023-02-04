package com.facespedes.apps.todo.backend.controllers.user_post_controller;

import com.facespedes.todo.user.application.UserCreator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public final class UserPostController {

    private final UserCreator userCreator;

    @PostMapping("/user")
    public void createUser() {
        userCreator.create("username", "password");
    }
}
