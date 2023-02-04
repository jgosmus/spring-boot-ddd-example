package com.facespedes.todo.user.application;

import org.springframework.stereotype.Service;

@Service
public class UserCreator {

    public void create(String username, String password) {
        System.out.println("User created");
    }
}
