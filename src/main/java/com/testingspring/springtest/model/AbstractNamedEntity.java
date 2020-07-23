package com.testingspring.springtest.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class AbstractNamedEntity extends AbstractBaseEntity{

    @NonNull
    protected String name;

    protected AbstractNamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

}

