package com.testingspring.springtest.model;

import lombok.*;

import java.util.Date;
import java.util.EnumSet;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class User extends AbstractNamedEntity {

    @NonNull
    @Email
    @NotBlank
    @Size(max = 50)
    private final String email;

    @NonNull
    @NotBlank
    @Size(min = 5, max = 100)
    private final String password;

    private boolean enable = true;

    @NonNull
    @NotNull
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
