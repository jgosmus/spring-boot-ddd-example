package com.facespedes.todo.shared.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
public abstract class IdentifierValueObject implements Serializable {
    protected final String id;

    protected IdentifierValueObject(String value) {
        ensureValidUuid(value);
        this.id = value;
    }

    private void ensureValidUuid(String value) {
        UUID.fromString(value);
    }

    protected IdentifierValueObject() {
        this.id = null;
    }

    @JsonValue
    public String value() {
        return id;
    }

}
