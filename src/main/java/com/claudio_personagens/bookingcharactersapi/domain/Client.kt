package com.claudio_personagens.bookingcharactersapi.domain

import com.claudio_personagens.bookingcharactersapi.base.AbstractBaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToMany

@Entity
data class Client (
    @Column(length = 150)
    val name: String?,

    @Column(length = 50)
    val password: String?,

    @ManyToMany
    val addresses: Set<Address>?
) : AbstractBaseEntity()