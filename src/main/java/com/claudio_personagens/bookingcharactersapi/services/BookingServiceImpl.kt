package com.claudio_personagens.bookingcharactersapi.services

import com.claudio_personagens.bookingcharactersapi.domain.Booking
import com.claudio_personagens.bookingcharactersapi.repositories.BookingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class BookingServiceImpl(
    private val bookingRepository: BookingRepository
) : BookingService {

    @Transactional
    override fun save(booking: Booking) = bookingRepository.save(booking)

    override fun findAll() = bookingRepository.findAll()
}