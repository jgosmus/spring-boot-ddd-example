package com.facespedes.todolist.task.application.use_cases;

import com.facespedes.todolist.shared.domain.Service;
import com.facespedes.todolist.task.application.dto.TaskFinderResponse;
import com.facespedes.todolist.task.domain.aggregate.Task;
import com.facespedes.todolist.task.domain.exceptions.TaskNotFoundException;
import com.facespedes.todolist.task.domain.ports.TaskRepository;
import com.facespedes.todolist.task.domain.services.DomainTaskFinder;
import com.facespedes.todolist.task.domain.vo.TaskId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public final class TaskFinder {

    private final TaskRepository taskRepository;


    public TaskFinderResponse findById(String id) {
        TaskId taskId = new TaskId(id);
        Task task = new DomainTaskFinder(taskRepository).findTask(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));

        return new TaskFinderResponse(task.getId().value(), task.getDescription(), task.getStatus().name(),
                task.getUserId().value());
    }
}
