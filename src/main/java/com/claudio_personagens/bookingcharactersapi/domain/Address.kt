package com.claudio_personagens.bookingcharactersapi.domain

import com.claudio_personagens.bookingcharactersapi.base.AbstractBaseEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity
data class Address (
    @Column(length = 150)
    val street: String?,

    @Column(length = 5)
    val number: String?,

    @Column(length = 100)
    val district: String?,

    @Column(length = 100)
    val complement: String?,

    @Column(length = 100)
    val city: String?,

    @Column(length = 100)
    val state: String?
) : AbstractBaseEntity()