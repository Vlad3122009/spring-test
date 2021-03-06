package com.testingspring.springtest.model;

import lombok.Data;
import lombok.NonNull;


import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@MappedSuperclass
public abstract class AbstractNamedEntity extends AbstractBaseEntity{

    @NonNull
    @NotBlank
    @Size(min = 2, max = 15)
    protected String name;

    protected AbstractNamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

