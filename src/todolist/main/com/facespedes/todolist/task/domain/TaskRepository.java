package com.facespedes.todolist.task.domain;

import com.facespedes.todolist.task.domain.vo.TaskId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, TaskId> {
}
