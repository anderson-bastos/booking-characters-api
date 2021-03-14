package com.claudio_personagens.bookingcharactersapi.domain

import com.claudio_personagens.bookingcharactersapi.base.BaseEntity
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class CharacterGroup(
    val price : Float = 0f,

    @OneToMany
    val characters: Set<Character>?
) : BaseEntity()