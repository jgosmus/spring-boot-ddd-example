package com.facespedes.todolist.user.domain.vo;

import com.facespedes.todolist.shared.domain.NumberValueObject;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class UserNumberTasks extends NumberValueObject {

    private long numberOfTasks;

    public UserNumberTasks(long numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }

    public long value() {
        return numberOfTasks;
    }

}
