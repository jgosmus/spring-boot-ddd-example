package com.facespedes.todo.user.application;

import com.facespedes.todo.user.domain.UserCreatedDomainEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SendEmailOnUserCreated {
    private final EmailSender emailSender;


    @EventListener
    public void sendEmail(UserCreatedDomainEvent event) {
        System.out.println("Event received: " + event);
        emailSender.sendEmail(event.getEmail(), "Thanks for creating an account!");
    }
}
