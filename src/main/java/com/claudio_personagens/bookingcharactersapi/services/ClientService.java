package com.claudio_personagens.bookingcharactersapi.services;

import com.claudio_personagens.bookingcharactersapi.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client save(Client client);
    Optional<Client> findByName(String name);
    Optional<Client> findById(String id);
    List<Client> findAll();
}
