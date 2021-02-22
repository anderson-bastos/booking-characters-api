package com.claudio_personagens.bookingcharactersapi.repositories;

import com.claudio_personagens.bookingcharactersapi.base.AbstractRepository;
import com.claudio_personagens.bookingcharactersapi.domain.Client;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ClientRepository extends AbstractRepository<Client, String>, JpaSpecificationExecutor<Client> {
    Optional<Client> findByName(String name);
}
