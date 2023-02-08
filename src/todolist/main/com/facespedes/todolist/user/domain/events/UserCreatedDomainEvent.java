package com.facespedes.todolist.user.domain.events;

import com.facespedes.todolist.shared.domain.bus.event.DomainEvent;

public class UserCreatedDomainEvent extends DomainEvent {
    private String id;
    private String email;

    public UserCreatedDomainEvent(String id, String email) {
        super(id);
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
