package com.claudio_personagens.bookingcharactersapi.domain

import com.claudio_personagens.bookingcharactersapi.base.BaseEntity
import java.time.Instant
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class Client (

    @Column(length = 150)
    val name: String?,

    @Column(length = 50)
    var password: String?,

    @ManyToMany
    val addresses: Set<Address>?

) : BaseEntity()