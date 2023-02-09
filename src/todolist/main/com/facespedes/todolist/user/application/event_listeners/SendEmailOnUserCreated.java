package com.facespedes.todolist.user.application.event_listeners;

import com.facespedes.todolist.shared.domain.Service;
import com.facespedes.todolist.user.application.use_cases.EmailSender;
import com.facespedes.todolist.user.domain.events.UserCreatedDomainEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;

@AllArgsConstructor
@Service
public final class SendEmailOnUserCreated {

    private final EmailSender emailSender;


    @EventListener
    public void sendEmail(UserCreatedDomainEvent event) {
        System.out.println("Event received: " + event);
        emailSender.sendEmail(event.getEmail(), "Thanks for creating an account!");
    }
}
