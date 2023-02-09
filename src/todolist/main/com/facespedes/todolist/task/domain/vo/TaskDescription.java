package com.facespedes.todolist.task.domain.vo;

import com.facespedes.todolist.shared.domain.StringValueObject;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TaskDescription extends StringValueObject {
    private String description;

    public TaskDescription(String description) {
        this.description = description;
    }

    @JsonValue
    public String value() {
        return description;
    }
}
