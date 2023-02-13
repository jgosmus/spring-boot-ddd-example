package com.facespedes.todolist.user.domain.aggregate;


import com.facespedes.todolist.shared.domain.AggregateRoot;
import com.facespedes.todolist.shared.domain.Ensure;
import com.facespedes.todolist.shared.domain.UserId;
import com.facespedes.todolist.user.domain.events.UserCreatedDomainEvent;
import com.facespedes.todolist.user.domain.vo.UserEmail;
import com.facespedes.todolist.user.domain.vo.UserNumberTasks;
import com.facespedes.todolist.user.domain.vo.UserPassword;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
        Ensure.notNull(id, "Id is required");
        Ensure.notNull(email, "Email is required");
        Ensure.notNull(password, "Password is required");
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

    public long getNumberOfTasks() {
        return numberOfTasks.value();
    }

    public void incrementNumberOfTasks() {
        this.numberOfTasks = new UserNumberTasks(this.numberOfTasks.value() + 1);
    }

    public void decrementNumberOfTasks() {
        this.numberOfTasks = new UserNumberTasks(this.numberOfTasks.value() - 1);
    }

}
