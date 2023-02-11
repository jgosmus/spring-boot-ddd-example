package com.facespedes.todolist.task.domain;

import com.facespedes.todolist.task.domain.vo.TaskDescription;
import com.github.javafaker.Faker;

public class TaskDescriptionMother {
    public static TaskDescription random() {
        return new TaskDescription(Faker.instance().lorem().sentence());
    }
}
