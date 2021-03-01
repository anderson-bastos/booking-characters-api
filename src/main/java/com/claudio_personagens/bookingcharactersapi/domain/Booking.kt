package com.claudio_personagens.bookingcharactersapi.domain

import com.claudio_personagens.bookingcharactersapi.base.AbstractBaseEntity
import java.time.Instant
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.OneToOne

@Entity
data class Booking (
    @OneToOne
    val client: Client?,

    @OneToOne
    val characterGroup: CharacterGroup?,
    val bookingAt: Instant?
): AbstractBaseEntity()