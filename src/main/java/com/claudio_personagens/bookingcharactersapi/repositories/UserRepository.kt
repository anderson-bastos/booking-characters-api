package com.claudio_personagens.bookingcharactersapi.repositories

import com.claudio_personagens.bookingcharactersapi.base.AbstractRepository
import com.claudio_personagens.bookingcharactersapi.security.domain.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : AbstractRepository<User, UUID> {
    fun findByEmail(email: String): User?
}