package com.facespedes.todolist.task.domain.events;

import com.facespedes.todolist.shared.domain.bus.event.DomainEvent;

public class TaskCreatedDomainEvent extends DomainEvent {

    private String description;
    private String status;
    private String userId;


    public TaskCreatedDomainEvent(String id, String description, String status, String userId) {
        super(id);
        this.description = description;
        this.status = status;
        this.userId = userId;
    }

}
