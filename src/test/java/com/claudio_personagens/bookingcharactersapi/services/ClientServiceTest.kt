package com.claudio_personagens.bookingcharactersapi.services

import com.claudio_personagens.bookingcharactersapi.domain.Client
import com.claudio_personagens.bookingcharactersapi.repositories.ClientRepository
import org.junit.Before
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

@ExtendWith(MockitoExtension::class)
class ClientServiceTest {

    @InjectMocks
    lateinit var clientService: ClientServiceImpl

    @Mock
    lateinit var clientRepository: ClientRepository

    lateinit var client : Client

    @BeforeEach
    fun init() {
        client = Client(
            name = "Test",
            password = null,
            addresses = null
        )
    }

    @Test
    fun `Should return client when save`() {
        `when`(clientRepository.save(client)).thenReturn(client)
        val result = clientService.save(client)

        Assertions.assertNotNull(result.id)
        Assertions.assertEquals(client.name, result.name)
        verify(clientRepository, times(1)).save(client)
    }

    @Test
    fun `Should return client when find by name`() {
        `when`(clientRepository.findByName("Test")).thenReturn(Optional.of(client))

        val result = clientService.findByName("Test")
        Assertions.assertTrue(result.isPresent)
    }

    @Test
    @DisplayName("should return client when find by id")
    fun findById() {
        `when`(clientRepository.findById(UUID.fromString("27cb1462-a9ee-4057-8daf-8a70188b8766")))
            .thenReturn(Optional.of(client))
        val result = clientService.findById(UUID.fromString("27cb1462-a9ee-4057-8daf-8a70188b8766"))
        Assertions.assertTrue(result.isPresent)
    }

    @Test
    fun `Should return a list of clients`() {
        val client = Client(
            name = "Test",
            password = null,
            addresses = null
        )
        val clients = listOf(client)
        `when`(clientRepository.findAll()).thenReturn(clients)

        val result = clientService.findAll()
        Assertions.assertFalse(result.isEmpty())
    }
}