package com.facespedes.todolist.task.application.use_cases;

import com.facespedes.todolist.shared.domain.Service;
import com.facespedes.todolist.shared.domain.bus.event.EventBus;
import com.facespedes.todolist.task.domain.aggregate.Task;
import com.facespedes.todolist.task.domain.exceptions.TaskNotFoundException;
import com.facespedes.todolist.task.domain.ports.TaskRepository;
import com.facespedes.todolist.task.domain.services.DomainTaskFinder;
import com.facespedes.todolist.task.domain.vo.TaskId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public final class TaskFinisher {

    private final TaskRepository taskRepository;
    private final EventBus eventBus;

    public void finishTask(String id) {
        TaskId taskId = new TaskId(id);
        Task task = new DomainTaskFinder(taskRepository).findTask(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));

        task.done();
        taskRepository.save(task);
        eventBus.publish(task.pullDomainEvents());
    }
}
