package com.claudio_personagens.bookingcharactersapi.repositories

import com.claudio_personagens.bookingcharactersapi.base.BaseRepository
import com.claudio_personagens.bookingcharactersapi.domain.Booking
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BookingRepository : BaseRepository<Booking, UUID>