package com.claudio_personagens.bookingcharactersapi.services;

import com.claudio_personagens.bookingcharactersapi.domain.Booking;
import com.claudio_personagens.bookingcharactersapi.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    @Transactional
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }
}
