package com.testingspring.springtest.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
//@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractBaseEntity {
    public static final int START_SEQ = 100000;

    @NonNull
    @Id
    @SequenceGenerator(name = "global_seqa", sequenceName = "global_seqa", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seqa")
    protected Integer id;

    protected AbstractBaseEntity(Integer id){this.id = id;}

    public boolean isNew(){return this.id == null;}

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
