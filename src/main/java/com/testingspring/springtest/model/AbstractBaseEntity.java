package com.testingspring.springtest.model;

import lombok.Data;
import lombok.NonNull;



@Data
public class AbstractBaseEntity {

    @NonNull
    protected Integer id;

    protected AbstractBaseEntity(Integer id){this.id = id;}

    public boolean isNew(){return this.id == null;}
}
