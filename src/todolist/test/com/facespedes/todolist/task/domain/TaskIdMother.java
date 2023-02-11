package com.facespedes.todolist.task.domain;

import com.facespedes.todolist.shared.domain.UuidMother;
import com.facespedes.todolist.task.domain.vo.TaskId;

public class TaskIdMother {
    public static TaskId random() {
        return new TaskId(UuidMother.random());
    }
}
