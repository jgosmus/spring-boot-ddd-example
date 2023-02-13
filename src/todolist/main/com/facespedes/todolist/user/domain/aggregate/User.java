package com.facespedes.todolist.user.domain.aggregate;


import com.facespedes.todolist.shared.domain.AggregateRoot;
import com.facespedes.todolist.shared.domain.Ensure;
import com.facespedes.todolist.shared.domain.UserId;
import com.facespedes.todolist.user.domain.events.UserCreatedDomainEvent;
import com.facespedes.todolist.user.domain.vo.UserEmail;
import com.facespedes.todolist.user.domain.vo.UserNumberTasks;
import com.facespedes.todolist.user.domain.vo.UserPassword;


public final class User extends AggregateRoot {

    private UserId id;
    private UserEmail email;
    private UserPassword password;
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
