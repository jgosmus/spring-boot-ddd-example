package com.facespedes.todo.user.domain;

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
