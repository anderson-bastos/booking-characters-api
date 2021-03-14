package com.claudio_personagens.bookingcharactersapi.dto.mapper

import com.claudio_personagens.bookingcharactersapi.domain.Client
import com.claudio_personagens.bookingcharactersapi.dto.ClientDto

interface ClientMapper {
    fun toDto(client: Client): ClientDto
}