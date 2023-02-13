package com.facespedes.todolist.user.domain.vo;

import com.facespedes.todolist.shared.domain.NumberValueObject;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class UserNumberTasks extends NumberValueObject {

    private Long numberOfTasks;

    public UserNumberTasks(long numberOfTasks) {
        if(numberOfTasks < 0)
            this.numberOfTasks = 0;
        else
            this.numberOfTasks = numberOfTasks;
    }

    public long value() {
        return numberOfTasks;
    }

}
