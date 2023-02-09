package com.facespedes.todolist.user.infrastructure.adapters;

import com.facespedes.todolist.shared.domain.Service;
import com.facespedes.todolist.user.domain.ports.MessageSender;

@Service
public class EmailMessageSender implements MessageSender {
    @Override
    public void sendMessage(String destination, String subject, String message) {
        System.out.println("Sending email to " + destination + " with subject: " + subject + " and message: " + message);
    }
}
