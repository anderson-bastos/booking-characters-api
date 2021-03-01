package com.claudio_personagens.bookingcharactersapi.services

import com.claudio_personagens.bookingcharactersapi.domain.Client
import com.claudio_personagens.bookingcharactersapi.repositories.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
interface ClientService {
    fun save(client: Client): Client
    fun findByName(name: String): Optional<Client>
    fun findById(id: UUID): Optional<Client>
    fun findAll(): List<Client>
}