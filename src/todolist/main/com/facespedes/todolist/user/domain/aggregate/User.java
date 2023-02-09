package com.facespedes.todolist.user.domain.aggregate;


import com.facespedes.todolist.shared.domain.AggregateRoot;
import com.facespedes.todolist.user.domain.events.UserCreatedDomainEvent;
import com.facespedes.todolist.user.domain.vo.UserEmail;
import com.facespedes.todolist.shared.domain.UserId;
import com.facespedes.todolist.user.domain.vo.UserNumberTasks;
import com.facespedes.todolist.user.domain.vo.UserPassword;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name = "users")
@Entity
public final class User extends AggregateRoot {

    @EmbeddedId
    private UserId id;

    @Embedded
    private UserEmail email;

    @Embedded
    private UserPassword password;

    @Embedded
    private UserNumberTasks numberOfTasks;

    public User(UserId id, UserEmail email, UserPassword password) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.numberOfTasks = new UserNumberTasks(0);

        this.record(new UserCreatedDomainEvent(id.value(), email.value()));
    }

    @Override
    public String getId() {
        return id.value();
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
}
