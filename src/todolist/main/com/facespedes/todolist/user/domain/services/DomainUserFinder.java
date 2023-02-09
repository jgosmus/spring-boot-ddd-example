package com.facespedes.todolist.user.domain.services;

import com.facespedes.todolist.user.domain.aggregate.User;
import com.facespedes.todolist.user.domain.ports.UserRepository;
import com.facespedes.todolist.shared.domain.UserId;

import java.util.Optional;

public final class DomainUserFinder {
    private final UserRepository userRepository;

    public DomainUserFinder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUser(UserId id) {
        return userRepository.findById(id);
    }
}
