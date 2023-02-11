package com.facespedes.todolist.user.application.event_listeners;

import com.facespedes.todolist.shared.domain.Service;
import com.facespedes.todolist.task.domain.events.TaskCreatedDomainEvent;
import com.facespedes.todolist.user.application.use_cases.NumTaskDecrementer;
import com.facespedes.todolist.user.application.use_cases.NumTaskIncrementer;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;

@AllArgsConstructor
@Service
public final class DecrementNumTasksOnTaskCompleted {

    private final NumTaskDecrementer numTaskDecrementer;


    @EventListener
    public void increment(TaskCreatedDomainEvent event) {
        numTaskDecrementer.decrement(event.getUserId());
        System.out.println("Decrementing num tasks");
    }
}
