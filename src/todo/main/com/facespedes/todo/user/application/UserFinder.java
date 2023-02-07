package com.facespedes.todo.user.application;

import com.facespedes.todo.user.domain.DomainUserFinder;
import com.facespedes.todo.user.domain.User;
import com.facespedes.todo.user.domain.UserId;
import com.facespedes.todo.user.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserFinder {

    private final DomainUserFinder domainUserFinder;

    public UserFinder(UserRepository userRepository) {
        this.domainUserFinder = new DomainUserFinder(userRepository);
    }

    public User findUser(String id) {
        UserId userId = new UserId(id);
        return domainUserFinder.findUser(userId).orElseThrow();
    }
}
