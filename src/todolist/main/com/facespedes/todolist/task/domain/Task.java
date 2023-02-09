package com.facespedes.todolist.task.domain;

import com.facespedes.todolist.shared.domain.AggregateRoot;
import com.facespedes.todolist.task.domain.enums.TaskStatus;
import com.facespedes.todolist.task.domain.events.TaskCreatedDomainEvent;
import com.facespedes.todolist.task.domain.vo.TaskDescription;
import com.facespedes.todolist.task.domain.vo.TaskId;
import com.facespedes.todolist.shared.domain.UserId;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

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

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


    public static Task create(TaskId id, TaskDescription description, UserId userId) {
        Task task = new Task();
        task.id = id;
        task.description = description;
        task.userId = userId;
        task.status = TaskStatus.PENDING;

        task.record(new TaskCreatedDomainEvent(id.value(), description.value(), task.status.toString(), userId.value()));

        return task;
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
