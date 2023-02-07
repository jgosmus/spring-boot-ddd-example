package com.facespedes.todo.shared.domain;

import com.facespedes.todo.shared.domain.bus.event.DomainEvent;
import com.facespedes.todo.shared.infrastructure.BaseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AggregateRoot extends BaseEntity {

    private List<DomainEvent> domainEvents = new ArrayList<>();

    public final List<DomainEvent> pullDomainEvents() {
        List<DomainEvent> events = domainEvents;
        domainEvents = Collections.emptyList();
        return events;
    }

    protected final void record(DomainEvent event) {
        domainEvents.add(event);
    }

}
