package com.facespedes.todo.user.domain;

import com.facespedes.todo.shared.domain.IdentifierValueObject;
import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
public final class UserId extends IdentifierValueObject {

    public UserId(String value) {
        super(value);
    }

}
