package com.claudio_personagens.bookingcharactersapi.services;

import com.claudio_personagens.bookingcharactersapi.domain.Booking;
import java.util.List;

public interface BookingService {
    public Booking save(Booking booking);
    public List<Booking> findAll();
}
