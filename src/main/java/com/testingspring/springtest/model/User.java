package com.testingspring.springtest.model;

import lombok.*;

import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

@Data
public class User extends AbstractNamedEntity {

    @NonNull
    private final String email;

    @NonNull
    private final String password;

    private boolean enable = true;

    @NonNull
    private final Date registered = new Date();

    @Singular
    private final Set<Role> roles;

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
