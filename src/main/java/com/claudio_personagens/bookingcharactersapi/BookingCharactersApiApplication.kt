package com.claudio_personagens.bookingcharactersapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [UserDetailsServiceAutoConfiguration::class])
class BookingCharactersApiApplication

fun main(args: Array<String>) {
    runApplication<BookingCharactersApiApplication>(*args)
}
