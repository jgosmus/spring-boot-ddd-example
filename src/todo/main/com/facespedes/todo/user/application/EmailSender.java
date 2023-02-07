package com.facespedes.todo.user.application;

import org.springframework.stereotype.Service;

@Service
public class EmailSender {
    public void sendEmail(String email, String message) {
        System.out.println("Sending email to " + email + " with message: " + message);
    }
}
