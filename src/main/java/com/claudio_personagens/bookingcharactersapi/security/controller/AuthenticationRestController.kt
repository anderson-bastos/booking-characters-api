package com.claudio_personagens.bookingcharactersapi.security.controller

import com.claudio_personagens.bookingcharactersapi.security.jwt.JwtAuthenticationRequest
import com.claudio_personagens.bookingcharactersapi.security.jwt.JwtTokenUtil
import com.claudio_personagens.bookingcharactersapi.security.model.CurrentUser
import com.claudio_personagens.bookingcharactersapi.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.HttpStatusCodeException
import javax.servlet.http.HttpServletRequest

@RestController
class AuthenticationRestController(
    private val authenticationManager: AuthenticationManager,
    private val jwtTokenUtil: JwtTokenUtil,
    private val userDetailsService: UserDetailsService,
    private val userService: UserService
) {

    @PostMapping(value = ["/api/auth"])
    @ResponseStatus(HttpStatus.OK)
    fun createAuthenticationToken(@RequestBody authenticationRequest: JwtAuthenticationRequest) =
        kotlin.runCatching {
            val authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                    authenticationRequest.email,
                    authenticationRequest.password
                )
            )
            SecurityContextHolder.getContext().authentication = authentication
            val userDetails = userDetailsService.loadUserByUsername(authenticationRequest.email)
            val token = jwtTokenUtil.generateToken(userDetails)
            val user = userService.findByEmail(authenticationRequest.email)
            CurrentUser(token, user)
        }.getOrElse {
            throw it
        }

    @PostMapping(value = ["/api/refresh"])
    @ResponseStatus(HttpStatus.OK)
    fun refreshAndGetAuthenticationToken(request: HttpServletRequest): ResponseEntity<*> {
        val token = request.getHeader("Authorization")
        val username = jwtTokenUtil.getUsernameFromToken(token)
        val user = username.let { userService.findByEmail(it!!) }
        return if (jwtTokenUtil.canTokenBeRefreshed(token)) {
            val refreshedToken = jwtTokenUtil.refreshToken(token)
            ResponseEntity.ok<CurrentUser>(CurrentUser(refreshedToken, user))
        } else {
            ResponseEntity.badRequest().body<Any>(null)
        }
    }
}