package com.claudio_personagens.bookingcharactersapi.domain;

import com.claudio_personagens.bookingcharactersapi.base.AbstractBaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User extends AbstractBaseEntity {

    @Column(length = 150)
    private String name;
    @Column(length = 50)
    private String password;

    @ManyToMany
    private Set<Role> roles;
}
