package com.claudio_personagens.bookingcharactersapi.services

import com.claudio_personagens.bookingcharactersapi.base.BaseEntity
import com.claudio_personagens.bookingcharactersapi.domain.Client
import com.claudio_personagens.bookingcharactersapi.repositories.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class ClientServiceImpl (
    private val clientRepository: ClientRepository
) : ClientService {

    @Autowired
    private lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder

    @Transactional
    override fun save(client: Client) : Client {
        //client.password = bCryptPasswordEncoder.encode(client.password)
        return clientRepository.save(client)
    }

    override fun findByName(name: String) = clientRepository.findByName(name)

    override fun findById(id: UUID) = clientRepository.findById(id)

    override fun findAll(): MutableList<Client> = clientRepository.findAll()

    override fun deleteById(id: UUID) = clientRepository.deleteById(id)
}