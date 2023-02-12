package com.facespedes.todolist.task.domain.services;

import com.facespedes.todolist.shared.domain.UserId;
import com.facespedes.todolist.task.domain.aggregate.Task;
import com.facespedes.todolist.task.domain.ports.TaskRepository;
import com.facespedes.todolist.task.domain.vo.TaskId;

import java.util.List;
import java.util.Optional;

public final class DomainTaskFinder {
    private final TaskRepository taskRepository;

    public DomainTaskFinder(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Optional<Task> findTask(TaskId id) {
        return taskRepository.findById(id);
    }

    public List<Task> findTasksByUser(UserId id) {
        return taskRepository.findByUserId(id);
    }
}
