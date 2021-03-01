package com.claudio_personagens.bookingcharactersapi.security.model

import com.claudio_personagens.bookingcharactersapi.security.domain.User

data class CurrentUser(
    var token: String?,
    var user: User?
)
