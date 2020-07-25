package com.testingspring.springtest.model;

import lombok.Data;
import lombok.NonNull;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AbstractNamedEntity extends AbstractBaseEntity{

    @NonNull
    @NotBlank
    @Size(min = 2, max = 100)
    protected String name;

    protected AbstractNamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

}

