package com.claudio_personagens.bookingcharactersapi.services

import com.claudio_personagens.bookingcharactersapi.domain.Booking
import com.claudio_personagens.bookingcharactersapi.repositories.BookingRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

interface BookingService {
    fun save(booking: Booking): Booking
    fun findAll(): List<Booking>?
}