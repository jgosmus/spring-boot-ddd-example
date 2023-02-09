package com.facespedes.todolist.user.application.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
public final class UserFinderResponse {
    private String id;
    private String email;
}
