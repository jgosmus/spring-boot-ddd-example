package com.facespedes.todolist.task.domain.vo;

import com.facespedes.todolist.shared.domain.StringValueObject;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TaskDescription extends StringValueObject {

    private String description;

    public TaskDescription(String description) {
        this.description = description;
    }

    public String value() {
        return description;
    }
}
