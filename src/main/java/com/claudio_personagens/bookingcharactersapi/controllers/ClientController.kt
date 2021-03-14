package com.claudio_personagens.bookingcharactersapi.controllers

import com.claudio_personagens.bookingcharactersapi.base.BaseEntity
import com.claudio_personagens.bookingcharactersapi.base.BaseService
import com.claudio_personagens.bookingcharactersapi.domain.Client
import com.claudio_personagens.bookingcharactersapi.services.ClientService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(ClientController.URL)
class ClientController(
    private val clientService: ClientService
) {
    companion object {
        const val URL = "/clients"
    }

    @RequestMapping(
        method = [RequestMethod.PUT, RequestMethod.POST]
    )
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody client: Client) : Client {
        println(client)
        return clientService.save(client)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: UUID) = clientService.findById(id)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAll() = clientService.findAll()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteById(@PathVariable id: UUID) = clientService.deleteById(id)
}