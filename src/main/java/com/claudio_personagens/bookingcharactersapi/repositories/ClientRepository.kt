package com.claudio_personagens.bookingcharactersapi.repositories

import com.claudio_personagens.bookingcharactersapi.base.BaseRepository
import com.claudio_personagens.bookingcharactersapi.domain.Client
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ClientRepository : BaseRepository<Client, UUID> {
    fun findByName(name: String): Optional<Client>
}