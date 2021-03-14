package com.claudio_personagens.bookingcharactersapi.domain;

import com.claudio_personagens.bookingcharactersapi.base.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CharacterGroup extends AbstractBaseEntity {

    private float price;

    @OneToMany
    private Set<Character> characters;
}
