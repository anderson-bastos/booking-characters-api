package com.claudio_personagens.bookingcharactersapi.domain

import com.claudio_personagens.bookingcharactersapi.base.AbstractBaseEntity
import javax.persistence.Entity

@Entity
data class Character (
    var price: Float = 0f
): AbstractBaseEntity()