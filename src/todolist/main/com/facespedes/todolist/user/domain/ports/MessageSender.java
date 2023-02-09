package com.facespedes.todolist.user.domain.ports;

public interface MessageSender {
    void sendMessage(String destination, String title, String message);
}
