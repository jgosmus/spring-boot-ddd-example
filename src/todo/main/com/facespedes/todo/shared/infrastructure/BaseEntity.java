package com.facespedes.todo.shared.infrastructure;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Transient;
import org.springframework.data.domain.Persistable;

@MappedSuperclass
public abstract class BaseEntity implements Persistable<String> {

    @Transient
    protected boolean isNew = true;

    @Override
    public boolean isNew() {
        return isNew;
    }


    @PrePersist
    @PostLoad
    private void setPersisted() {
        isNew = false;
    }

}
