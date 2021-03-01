package com.claudio_personagens.bookingcharactersapi.services

import com.claudio_personagens.bookingcharactersapi.domain.Client
import com.claudio_personagens.bookingcharactersapi.repositories.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ClientServiceImpl (
    private val clientRepository: ClientRepository
) : ClientService {

    override fun save(client: Client): Client {
        return clientRepository.save(client)
    }

    override fun findByName(name: String): Optional<Client> {
        return clientRepository.findByName(name)
    }

    override fun findById(id: UUID): Optional<Client> {
        return clientRepository.findById(id)
    }

    override fun findAll(): List<Client> {
        return clientRepository.findAll()
    }
}