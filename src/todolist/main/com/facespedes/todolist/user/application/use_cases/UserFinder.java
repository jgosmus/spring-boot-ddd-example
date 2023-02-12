package com.facespedes.todolist.user.application.use_cases;

import com.facespedes.todolist.shared.domain.Service;
import com.facespedes.todolist.task.domain.aggregate.Task;
import com.facespedes.todolist.task.domain.ports.TaskRepository;
import com.facespedes.todolist.task.domain.services.DomainTaskFinder;
import com.facespedes.todolist.user.application.dto.TaskResponse;
import com.facespedes.todolist.user.application.dto.UserFinderResponse;
import com.facespedes.todolist.user.application.dto.UserTasksFinderResponse;
import com.facespedes.todolist.user.domain.exceptions.UserNotFoundException;
import com.facespedes.todolist.user.domain.services.DomainUserFinder;
import com.facespedes.todolist.user.domain.aggregate.User;
import com.facespedes.todolist.shared.domain.UserId;
import com.facespedes.todolist.user.domain.ports.UserRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Service
public final class UserFinder {

    private final UserRepository userRepository;


    public UserFinderResponse findUser(String id) {
        UserId userId = new UserId(id);
        User user = findUser(userId);
        return new UserFinderResponse(user.getId().value(), user.getEmail(), user.getNumberOfTasks());
    }

    private User findUser(UserId userId) {
        return new DomainUserFinder(userRepository).findUser(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
