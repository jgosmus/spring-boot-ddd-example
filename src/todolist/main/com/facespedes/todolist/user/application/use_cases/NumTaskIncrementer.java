package com.facespedes.todolist.user.application.use_cases;

import com.facespedes.todolist.shared.domain.Service;
import com.facespedes.todolist.shared.domain.UserId;
import com.facespedes.todolist.user.domain.aggregate.User;
import com.facespedes.todolist.user.domain.ports.UserRepository;
import com.facespedes.todolist.user.domain.services.DomainUserFinder;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@Service
public class NumTaskIncrementer {

    private final UserRepository userRepository;


    public void increment(String userId) {
        Optional<User> optionalUser = new DomainUserFinder(userRepository).findUser(new UserId(userId));
        optionalUser.ifPresent(user -> {
            user.incrementNumberOfTasks();
            userRepository.save(user);
        });
    }
}
