package com.claudio_personagens.bookingcharactersapi.security.service

import com.claudio_personagens.bookingcharactersapi.security.jwt.JwtUserFactory
import com.claudio_personagens.bookingcharactersapi.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class JwtUserDetailsServiceImpl(
    private val userService: UserService
) : UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        val user = userService.findByEmail(email)
        return if (user == null) {
            throw UsernameNotFoundException(String.format("No user found with username '%s'.", email))
        } else {
            JwtUserFactory.create(user)
        }
    }
}