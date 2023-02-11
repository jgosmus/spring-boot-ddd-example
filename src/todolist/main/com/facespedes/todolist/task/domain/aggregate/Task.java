package com.facespedes.todolist.task.domain.aggregate;

import com.facespedes.todolist.shared.domain.AggregateRoot;
import com.facespedes.todolist.shared.domain.UserId;
import com.facespedes.todolist.task.domain.enums.TaskStatus;
import com.facespedes.todolist.task.domain.events.TaskCompletedDomainEvent;
import com.facespedes.todolist.task.domain.events.TaskCreatedDomainEvent;
import com.facespedes.todolist.task.domain.vo.TaskDescription;
import com.facespedes.todolist.task.domain.vo.TaskId;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name = "tasks")
@Entity
public class Task extends AggregateRoot {

    @EmbeddedId
    private TaskId id;

    @Embedded
    private TaskDescription description;

    @Enumerated(value = EnumType.STRING)
    private TaskStatus status;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "user_id"))
    private UserId userId;


    public static Task create(TaskId id, TaskDescription description, UserId userId) {
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

}
