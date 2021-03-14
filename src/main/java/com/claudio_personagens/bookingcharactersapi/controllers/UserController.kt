package com.claudio_personagens.bookingcharactersapi.controllers

import com.claudio_personagens.bookingcharactersapi.security.domain.User
import com.claudio_personagens.bookingcharactersapi.services.UserService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(UserController.URL)
class UserController (
    private val userService: UserService
) {

    companion object {
        @JvmStatic
        private val logger = LoggerFactory.getLogger(UserController::class.java)

        const val URL = "/users"
    }

    @PostMapping
    fun save(@RequestBody user: User) = userService.save(user)

    @GetMapping
    fun getlAll() = userService.findAll()
}