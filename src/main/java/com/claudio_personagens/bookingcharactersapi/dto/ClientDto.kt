package com.claudio_personagens.bookingcharactersapi.dto

import com.claudio_personagens.bookingcharactersapi.domain.Address

class ClientDto(
    val name: String?,
    var password: String?,
    val addresses: Set<Address>?
)