package com.testingspring.springtest.model;

import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.Date;
import java.util.EnumSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Table(name = "usersA", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "users_unique_email_idx")})
@Entity
public class User extends AbstractNamedEntity {

    @NonNull
    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    private final String email;

    @NonNull
    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    private final String password;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enable = true;

    @NonNull
    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()")
    @NotNull
    private final Date registered = new Date();

    @Singular
    @BatchSize(size = 200)
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "usera_roles", joinColumns = @JoinColumn(name = "user_id"), //связывает юзер_роли с юзер_id
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role"}, name = "user_roles_unique_idx")})
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
