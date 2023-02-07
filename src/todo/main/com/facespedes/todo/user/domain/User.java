package com.facespedes.todo.user.domain;


import com.facespedes.todo.shared.domain.AggregateRoot;
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

    public User(UserId id, UserEmail email, UserPassword password) {
        this.id = id;
        this.email = email;
        this.password = password;

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
}
