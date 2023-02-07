package com.facespedes.todo.user.application;

import com.facespedes.todo.shared.domain.bus.event.EventBus;
import com.facespedes.todo.user.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserCreator {

    private final UserRepository userRepository;
    private final EventBus eventBus;

    public void create(String id, String email, String password) {
        Optional<User> optionalUser = new DomainUserFinder(userRepository).findUser(new UserId(id));
        if (optionalUser.isPresent()) {
            throw new RuntimeException("User already exists");
        }

        UserId userId = new UserId(id);
        UserEmail userEmail = new UserEmail(email);
        UserPassword userPassword = new UserPassword(password);
        User user = new User(userId, userEmail, userPassword);
        userRepository.save(user);
        eventBus.publish(user.pullDomainEvents());
    }
}
