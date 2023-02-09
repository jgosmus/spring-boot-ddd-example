package com.facespedes.todolist.shared.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
import java.util.Objects;
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

    public String value() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdentifierValueObject that = (IdentifierValueObject) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
