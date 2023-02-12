package com.facespedes.todolist.user.application.event_listeners;

import com.facespedes.todolist.shared.domain.Service;
import com.facespedes.todolist.task.domain.events.TaskCompletedDomainEvent;
import com.facespedes.todolist.user.application.use_cases.NumTaskDecrementer;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;

@AllArgsConstructor
@Service
public final class DecrementNumTasksOnTaskCompleted {

    private final NumTaskDecrementer numTaskDecrementer;


    @EventListener
    public void increment(TaskCompletedDomainEvent event) {
        numTaskDecrementer.decrement(event.getUserId());
        System.out.println("Decrementing num tasks");
    }
}
