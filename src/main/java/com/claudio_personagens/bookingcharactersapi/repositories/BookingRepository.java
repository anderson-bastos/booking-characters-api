package com.claudio_personagens.bookingcharactersapi.repositories;

import com.claudio_personagens.bookingcharactersapi.base.AbstractRepository;
import com.claudio_personagens.bookingcharactersapi.domain.Booking;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookingRepository extends AbstractRepository<Booking, String>, JpaSpecificationExecutor<Booking> {
}
