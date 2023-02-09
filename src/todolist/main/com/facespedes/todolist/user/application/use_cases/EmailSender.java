package com.facespedes.todolist.user.application.use_cases;


import com.facespedes.todolist.shared.domain.Service;

@Service
public class EmailSender {

    public void sendEmail(String email, String message) {
        System.out.println("Sending email to " + email + " with message: " + message);
    }
}
