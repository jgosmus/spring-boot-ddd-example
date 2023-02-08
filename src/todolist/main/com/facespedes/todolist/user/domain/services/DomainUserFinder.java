package com.facespedes.todolist.user.domain.services;

import com.facespedes.todolist.user.domain.User;
import com.facespedes.todolist.user.domain.UserRepository;
import com.facespedes.todolist.user.domain.vo.UserId;

import java.util.Optional;

public class DomainUserFinder {
    private UserRepository userRepository;

    public DomainUserFinder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUser(UserId id) {
        return userRepository.findById(id);
    }
}
