package com.testingspring.springtest.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;


@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AbstractBaseEntity {

    @NonNull
    protected Integer id;

    protected AbstractBaseEntity(Integer id){this.id = id;}

    public boolean isNew(){return this.id == null;}
}
