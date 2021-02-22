package com.claudio_personagens.bookingcharactersapi.services;

import com.claudio_personagens.bookingcharactersapi.domain.Client;
import com.claudio_personagens.bookingcharactersapi.repositories.ClientRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    private Client client;

    @BeforeEach
    public void init(){
        client = Client.builder()
                .name("Test")
                .password("Test")
                .build();
    }

    @Test
    @DisplayName("should return client when save")
    public void save(){
        Mockito.when(clientRepository.save(client)).thenReturn(client);

        Client result = clientService.save(client);

        Assertions.assertNotNull(result.getId());
        Assertions.assertEquals(client.getName(), result.getName());
        Assertions.assertEquals(client.getPassword(), result.getPassword());
        Mockito.verify(clientRepository, Mockito.times(1)).save(client);
    }

    @Test
    @DisplayName("should return client when find by name")
    public void findByName(){
        Mockito.when(clientRepository.findByName("Test")).thenReturn(Optional.of(client));

        Optional<Client> result = clientService.findByName("Test");
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    @DisplayName("should return client when find by id")
    public void findById(){
        Mockito.when(clientRepository.findById("27cb1462-a9ee-4057-8daf-8a70188b8766")).thenReturn(Optional.of(client));

        Optional<Client> result = clientService.findById("27cb1462-a9ee-4057-8daf-8a70188b8766");
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    @DisplayName("should return a list of clients")
    public void findAll(){
        List<Client> clients = List.of(client);

        Mockito.when(clientRepository.findAll()).thenReturn(clients);

        List<Client> result = clientService.findAll();
        Assertions.assertFalse(result.isEmpty());
    }
}
