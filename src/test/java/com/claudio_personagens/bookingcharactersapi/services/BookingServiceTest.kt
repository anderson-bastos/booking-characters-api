package com.claudio_personagens.bookingcharactersapi.services

import com.claudio_personagens.bookingcharactersapi.domain.Booking
import com.claudio_personagens.bookingcharactersapi.domain.Character
import com.claudio_personagens.bookingcharactersapi.domain.CharacterGroup
import com.claudio_personagens.bookingcharactersapi.domain.Client
import com.claudio_personagens.bookingcharactersapi.repositories.BookingRepository
import org.junit.Before
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.time.Instant

@ExtendWith(MockitoExtension::class)
class BookingServiceTest {

    @InjectMocks
    lateinit var bookingService: BookingServiceImpl

    @Mock
    lateinit var bookingRepository: BookingRepository

    lateinit var booking: Booking

    @BeforeEach
    fun init() {
        val character = Character(
           12.50f
        )

        val characterGroup = CharacterGroup(
            15.0f,
            mutableSetOf(character)
        )

        val client = Client(
            "Test",
            null,
            null
        )

        booking = Booking(
            client = client,
            characterGroup = characterGroup,
            bookingAt = Instant.now()
        )
    }

    @Test
    fun `should booking a character and return booking when save`() {
        Mockito.doReturn(booking).`when`(bookingRepository).save(booking)
        val result = bookingService.save(booking)

        Assertions.assertNotNull(result)
        Mockito.verify(bookingRepository, Mockito.times(1)).save(booking)
    }

    @Test
    fun `should return all bookings`() {
        val bookings = mutableListOf(booking)
        Mockito.`when`(bookingRepository.findAll()).thenReturn(bookings as List<Booking?>?)

        val result = bookingService.findAll()

        Assertions.assertFalse(result.isEmpty())
        Assertions.assertEquals(1, result.count())
    }
}