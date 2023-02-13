package com.facespedes.todolist.task.domain.aggregate;

import com.facespedes.todolist.shared.domain.AggregateRoot;
import com.facespedes.todolist.shared.domain.Ensure;
import com.facespedes.todolist.shared.domain.UserId;
import com.facespedes.todolist.task.domain.enums.TaskStatus;
import com.facespedes.todolist.task.domain.events.TaskCompletedDomainEvent;
import com.facespedes.todolist.task.domain.events.TaskCreatedDomainEvent;
import com.facespedes.todolist.task.domain.vo.TaskDescription;
import com.facespedes.todolist.task.domain.vo.TaskId;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Task extends AggregateRoot {

    private TaskId id;
    private TaskDescription description;
    private TaskStatus status;
    private UserId userId;


    public static Task create(TaskId id, TaskDescription description, UserId userId) {
        Ensure.notNull(id, "Id is required");
        Ensure.notNull(description, "Description is required");
        Ensure.notNull(userId, "UserId is required");
        Task task = new Task();
        task.id = id;
        task.description = description;
        task.userId = userId;
        task.status = TaskStatus.PENDING;

        task.record(new TaskCreatedDomainEvent(id.value(), description.value(), task.status.toString(), userId.value()));

        return task;
    }

    public void done() {
        this.status = TaskStatus.COMPLETED;
        this.record(new TaskCompletedDomainEvent(id.value(), description.value(), status.toString(), userId.value()));
    }

    public boolean isDone() {
        return this.status == TaskStatus.COMPLETED;
    }

    @Override
    public TaskId getId() {
        return id;
    }

    public String getDescription() {
        return description.value();
    }

    public TaskStatus getStatus() {
        return status;
    }

    public UserId getUserId() {
        return userId;
    }

}
