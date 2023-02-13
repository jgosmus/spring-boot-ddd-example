package com.facespedes.todolist.task.domain.vo;

import com.facespedes.todolist.shared.domain.StringValueObject;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
public class TaskDescription extends StringValueObject {

    private String description;

    public TaskDescription(String description) {
        Objects.requireNonNull(description);
        this.description = description;
    }

    public String value() {
        return description;
    }
}
