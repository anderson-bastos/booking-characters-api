package com.claudio_personagens.bookingcharactersapi.security.jwt

class JwtAuthenticationRequest(
    val email : String = "",
    var password: String = ""
)