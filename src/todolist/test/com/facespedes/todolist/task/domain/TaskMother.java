package com.facespedes.todolist.task.domain;

import com.facespedes.todolist.task.domain.aggregate.Task;
import com.facespedes.todolist.user.domain.UserIdMother;

public class TaskMother {
    public static Task random() {
        return Task.create(TaskIdMother.random(), TaskDescriptionMother.random(), UserIdMother.random());
    }
}
