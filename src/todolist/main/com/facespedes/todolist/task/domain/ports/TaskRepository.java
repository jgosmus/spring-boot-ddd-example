package com.facespedes.todolist.task.domain.ports;

import com.facespedes.todolist.task.domain.aggregate.Task;
import com.facespedes.todolist.task.domain.vo.TaskId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, TaskId> {
}
