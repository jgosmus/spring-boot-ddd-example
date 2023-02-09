package com.facespedes.todolist.task.domain;

import com.facespedes.todolist.shared.domain.AggregateRoot;
import com.facespedes.todolist.task.domain.enums.TaskStatus;
import com.facespedes.todolist.task.domain.vo.TaskDescription;
import com.facespedes.todolist.task.domain.vo.TaskId;
import com.facespedes.todolist.shared.domain.UserId;
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
    private UserId userId;

    public Task(TaskId id, TaskDescription description, UserId userId) {
        this.id = id;
        this.description = description;
        this.userId = userId;
        this.status = TaskStatus.PENDING;
    }

    @Override
    public String getId() {
        return id.value();
    }

    public String getDescription() {
        return description.value();
    }

    public TaskStatus getStatus() {
        return status;
    }

}
