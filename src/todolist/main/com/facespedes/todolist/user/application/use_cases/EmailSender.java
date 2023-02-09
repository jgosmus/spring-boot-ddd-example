package com.facespedes.todolist.user.application.use_cases;


import com.facespedes.todolist.shared.domain.Service;
import com.facespedes.todolist.user.domain.ports.MessageSender;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmailSender {

    private MessageSender messageSender;


    public void sendEmail(String email, String subject, String message) {
        messageSender.sendMessage(email, subject, message);
    }
}
