package com.facespedes.todolist.user.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class UserFinderResponse {
    private String id;
    private String email;
}
