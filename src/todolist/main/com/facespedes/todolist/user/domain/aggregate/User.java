package com.facespedes.todolist.user.domain.aggregate;


import com.facespedes.todolist.shared.domain.AggregateRoot;
import com.facespedes.todolist.shared.domain.UserId;
import com.facespedes.todolist.user.domain.events.UserCreatedDomainEvent;
import com.facespedes.todolist.user.domain.vo.UserEmail;
import com.facespedes.todolist.user.domain.vo.UserNumberTasks;
import com.facespedes.todolist.user.domain.vo.UserPassword;
import jakarta.persistence.*;

import java.util.Objects;

@Table(name = "users")
@Entity
public final class User extends AggregateRoot {

    @Column(length = 36)
    @EmbeddedId
    private UserId id;

    @Embedded
    private UserEmail email;

    @Embedded
    private UserPassword password;

    @Embedded
    private UserNumberTasks numberOfTasks;

    public static User create(UserId id, UserEmail email, UserPassword password) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(email);
        Objects.requireNonNull(password);
        User user = new User();
        user.id = id;
        user.email = email;
        user.password = password;
        user.numberOfTasks = new UserNumberTasks(0);

        user.record(new UserCreatedDomainEvent(id.value(), email.value()));
        return user;
    }

    @Override
    public UserId getId() {
        return id;
    }

    public String getEmail() {
        return email.value();
    }

    public String getPassword() {
        return password.value();
    }

    public long getNumberOfTasks() {
        return numberOfTasks.value();
    }

    public void incrementNumberOfTasks() {
        this.numberOfTasks = new UserNumberTasks(this.numberOfTasks.value() + 1);
    }

    public User() {
        this.id = new UserId();
    }
}
