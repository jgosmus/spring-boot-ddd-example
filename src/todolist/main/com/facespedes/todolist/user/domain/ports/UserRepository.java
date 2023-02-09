package com.facespedes.todolist.user.domain.ports;

import com.facespedes.todolist.shared.domain.UserId;
import com.facespedes.todolist.user.domain.aggregate.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, UserId> {
}
