package com.facespedes.todo.shared.infrastructure.bus.event;

import com.facespedes.todo.shared.domain.bus.event.DomainEvent;
import com.facespedes.todo.shared.domain.bus.event.EventBus;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SpringApplicationEventBus implements EventBus {

    private final ApplicationEventPublisher publisher;

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent event) {
        this.publisher.publishEvent(event);
    }
}
