package com.facespedes.todolist.task.application;

import com.facespedes.todolist.shared.domain.Service;
import com.facespedes.todolist.shared.domain.UserId;
import com.facespedes.todolist.shared.domain.bus.event.EventBus;
import com.facespedes.todolist.task.domain.Task;
import com.facespedes.todolist.task.domain.TaskRepository;
import com.facespedes.todolist.task.domain.vo.TaskDescription;
import com.facespedes.todolist.task.domain.vo.TaskId;
import com.facespedes.todolist.user.domain.UserRepository;
import com.facespedes.todolist.user.domain.services.DomainUserFinder;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TaskCreator {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final EventBus eventBus;


    public void create(String id, String description, String userIdString) {
        UserId userId = new UserId(userIdString);
        new DomainUserFinder(userRepository).findUser(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        TaskId taskId = new TaskId(id);
        TaskDescription taskDescription = new TaskDescription(description);
        Task task = Task.create(taskId, taskDescription, userId);
        taskRepository.save(task);
        eventBus.publish(task.pullDomainEvents());
    }
}
