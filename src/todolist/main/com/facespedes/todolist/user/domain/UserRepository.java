package com.facespedes.todolist.user.domain;

import com.facespedes.todolist.shared.domain.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UserId> {
}
