package com.claudio_personagens.bookingcharactersapi.security.domain

import com.claudio_personagens.bookingcharactersapi.base.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "users")
data class User (
    @Column(length = 150)
    val name: String,

    @Column(length = 150)
    val email: String,

    @Column(length = 150)
    var password: String,

    @Enumerated(EnumType.STRING)
    @Column(length = 150)
    var role: Role = Role.ROLE_ADMIN
) : BaseEntity()


enum class Role {
    ROLE_ADMIN, ROLE_CUSTOMER
}