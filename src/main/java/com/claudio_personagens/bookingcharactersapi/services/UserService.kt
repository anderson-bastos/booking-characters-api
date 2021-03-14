package com.claudio_personagens.bookingcharactersapi.services

import com.claudio_personagens.bookingcharactersapi.security.domain.User

interface UserService {
    fun save(user: User): User
    fun findAll(): List<User>
    fun findByEmail(email: String): User?
}