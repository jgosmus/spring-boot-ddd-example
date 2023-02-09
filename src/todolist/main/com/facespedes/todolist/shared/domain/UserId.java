package com.facespedes.todolist.shared.domain;

import com.facespedes.todolist.shared.domain.IdentifierValueObject;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Embeddable
public final class UserId extends IdentifierValueObject {

    public UserId(String value) {
        super(value);
    }

}
