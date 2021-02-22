package com.claudio_personagens.bookingcharactersapi.services;

import com.claudio_personagens.bookingcharactersapi.domain.Booking;
import com.claudio_personagens.bookingcharactersapi.domain.Character;
import com.claudio_personagens.bookingcharactersapi.domain.CharacterGroup;
import com.claudio_personagens.bookingcharactersapi.domain.Client;
import com.claudio_personagens.bookingcharactersapi.repositories.BookingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    private Booking booking;

    @BeforeEach
    public void init(){
        Character character = Character.builder()
                .price(12.50F)
                .build();
        CharacterGroup characterGroup = CharacterGroup.builder()
                .characters(Set.of(character))
                .build();

        booking = Booking.builder()
                .client(Client.builder().name("Test").password("Test").build())
                .characterGroup(characterGroup)
                .bookingAt(LocalDate.now())
                .build();
    }

    @Test
    @DisplayName("should booking a character and return booking when save")
    public void save(){
        Mockito.when(bookingRepository.save(booking)).thenReturn(booking);

        Booking result = bookingService.save(booking);

        Assertions.assertNotNull(result.getId());
        Mockito.verify(bookingRepository, Mockito.times(1)).save(booking);
    }

    @Test
    @DisplayName("should return all bookings")
    public void findAll(){
        List<Booking> bookings = List.of(booking);
        Mockito.when(bookingRepository.findAll()).thenReturn(bookings);

        List<Booking> result = bookingService.findAll();

        Assertions.assertFalse(result.isEmpty());
    }
}
