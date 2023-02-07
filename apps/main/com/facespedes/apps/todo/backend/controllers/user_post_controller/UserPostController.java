package com.facespedes.apps.todo.backend.controllers.user_post_controller;

import com.facespedes.todo.user.application.UserCreator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@AllArgsConstructor
@RestController
public final class UserPostController {

    private final UserCreator userCreator;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("user")
    public void createUser(@RequestBody UserPostRequest userPostRequest) {
        userCreator.create(UUID.randomUUID().toString(), userPostRequest.email(), userPostRequest.password());
    }
}

record UserPostRequest(String email, String password) {
}
