package com.claudio_personagens.bookingcharactersapi.services;

import com.claudio_personagens.bookingcharactersapi.domain.Booking;
import java.util.List;

public interface BookingService {
    Booking save(Booking booking);
    List<Booking> findAll();
}
