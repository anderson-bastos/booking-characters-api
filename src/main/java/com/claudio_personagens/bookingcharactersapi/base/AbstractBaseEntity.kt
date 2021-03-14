package com.claudio_personagens.bookingcharactersapi.base

import java.time.Instant
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class AbstractBaseEntity (
    @Id
    @Column(length = 36)
    open val id: UUID = UUID.randomUUID(),
    open var createdAt: Instant = Instant.now()
)