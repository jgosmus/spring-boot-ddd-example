package com.facespedes.todolist.task.domain.ports;

import com.facespedes.todolist.shared.domain.UserId;
import com.facespedes.todolist.task.domain.aggregate.Task;
import com.facespedes.todolist.task.domain.vo.TaskId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, TaskId> {
    List<Task> findByUserId(UserId id);
}
