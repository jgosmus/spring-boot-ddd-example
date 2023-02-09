package com.facespedes.todolist.user.application;

import com.facespedes.todolist.shared.domain.Service;
import com.facespedes.todolist.shared.domain.bus.event.EventBus;
import com.facespedes.todolist.user.domain.*;
import com.facespedes.todolist.user.domain.services.DomainUserFinder;
import com.facespedes.todolist.user.domain.vo.UserEmail;
import com.facespedes.todolist.shared.domain.UserId;
import com.facespedes.todolist.user.domain.vo.UserPassword;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserCreator {

    private final UserRepository userRepository;
    private final EventBus eventBus;


    public void create(String id, String email, String password) {
        UserId userId = new UserId(id);
        Optional<User> optionalUser = new DomainUserFinder(userRepository).findUser(userId);
        optionalUser.ifPresent(user -> {
            throw new RuntimeException("User already exists");
        });

        UserEmail userEmail = new UserEmail(email);
        UserPassword userPassword = new UserPassword(password);
        User user = new User(userId, userEmail, userPassword);
        userRepository.save(user);
        eventBus.publish(user.pullDomainEvents());
    }
}
