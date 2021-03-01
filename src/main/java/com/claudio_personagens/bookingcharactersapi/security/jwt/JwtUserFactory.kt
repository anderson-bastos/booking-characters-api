package com.claudio_personagens.bookingcharactersapi.security.jwt

import com.claudio_personagens.bookingcharactersapi.security.domain.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

object JwtUserFactory {
    @JvmStatic
	fun create(user: User) =
	    JwtUser(user.id, user.email, user.password, listOf<GrantedAuthority>(SimpleGrantedAuthority(user.role.name)))
}