package com.claudio_personagens.bookingcharactersapi.domain;

import com.claudio_personagens.bookingcharactersapi.base.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Client extends AbstractBaseEntity {
    @Column(length = 150)
    private String name;
    @Column(length = 50)
    private String password;

    @ManyToMany
    private Set<Address> addresses;
}
