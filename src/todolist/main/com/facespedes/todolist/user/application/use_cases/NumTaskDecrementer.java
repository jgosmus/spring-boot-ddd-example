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
public class NumTaskDecrementer {

    private final UserRepository userRepository;


    public void decrement(String userId) {
        Optional<User> optionalUser = new DomainUserFinder(userRepository).findUser(new UserId(userId));
        optionalUser.ifPresent(user -> {
            user.decrementNumberOfTasks();
            userRepository.save(user);
        });
    }
}
