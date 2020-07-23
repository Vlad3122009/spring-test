package com.testingspring.springtest.model;

import lombok.*;

import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

@Data
public class User extends AbstractNamedEntity {

    @NonNull
    private String email;

    @NonNull
    private String password;

    @NonNull
    private boolean enable = true;

    @NonNull
    private Date registered = new Date();

    @Singular
    private Set<Role> roles;

    protected User(Integer id, String name,String email, String password, Role role, Role... roles) {
        this(id, name, email, password, true,EnumSet.of(role,roles));
    }

    public User(Integer id, String name, String email, String password, boolean enable, Set<Role> roles) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.enable = enable;
        this.roles = roles;
    }
}
