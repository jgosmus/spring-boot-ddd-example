package com.facespedes.todolist.task.domain.vo;

import com.facespedes.todolist.shared.domain.IdentifierValueObject;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Embeddable
public final class TaskId extends IdentifierValueObject {

    public TaskId(String value) {
        super(value);
    }
}
