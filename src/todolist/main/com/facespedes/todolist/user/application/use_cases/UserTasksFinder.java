package com.facespedes.todolist.user.application.use_cases;

import com.facespedes.todolist.shared.domain.Service;
import com.facespedes.todolist.shared.domain.UserId;
import com.facespedes.todolist.task.domain.ports.TaskRepository;
import com.facespedes.todolist.task.domain.services.DomainTaskFinder;
import com.facespedes.todolist.user.application.dto.TaskResponse;
import com.facespedes.todolist.user.application.dto.UserFinderResponse;
import com.facespedes.todolist.user.application.dto.UserTasksFinderResponse;
import com.facespedes.todolist.user.domain.aggregate.User;
import com.facespedes.todolist.user.domain.exceptions.UserNotFoundException;
import com.facespedes.todolist.user.domain.ports.UserRepository;
import com.facespedes.todolist.user.domain.services.DomainUserFinder;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Service
public final class UserTasksFinder {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;


    public UserTasksFinderResponse findUserWithTasks(String id) {
        UserId userId = new UserId(id);
        User user = findUser(userId);

        List<TaskResponse> tasksByUser = new DomainTaskFinder(taskRepository).findTasksByUser(userId).stream()
                .map(task -> new TaskResponse(task.getId().value(), task.getDescription(), task.getStatus().name()))
                .toList();

        return new UserTasksFinderResponse(user.getId().value(), user.getEmail(), tasksByUser);
    }

    private User findUser(UserId userId) {
        return new DomainUserFinder(userRepository).findUser(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
