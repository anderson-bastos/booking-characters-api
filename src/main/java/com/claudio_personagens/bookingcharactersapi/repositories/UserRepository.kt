package com.claudio_personagens.bookingcharactersapi.repositories

import com.claudio_personagens.bookingcharactersapi.base.BaseRepository
import com.claudio_personagens.bookingcharactersapi.security.domain.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : BaseRepository<User, UUID> {
    fun findByEmail(email: String): User?
}