package com.claudio_personagens.bookingcharactersapi.repositories

import com.claudio_personagens.bookingcharactersapi.base.AbstractRepository
import com.claudio_personagens.bookingcharactersapi.domain.Client
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ClientRepository : AbstractRepository<Client, UUID> {
    fun findByName(name: String): Optional<Client>
}