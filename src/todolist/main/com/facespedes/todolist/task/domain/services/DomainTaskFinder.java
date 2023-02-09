package com.facespedes.todolist.task.domain.services;

import com.facespedes.todolist.task.domain.Task;
import com.facespedes.todolist.task.domain.TaskRepository;
import com.facespedes.todolist.task.domain.vo.TaskId;

import java.util.Optional;

public final class DomainTaskFinder {
    private final TaskRepository taskRepository;

    public DomainTaskFinder(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Optional<Task> findTask(TaskId id) {
        return taskRepository.findById(id);
    }
}
