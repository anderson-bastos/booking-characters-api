package com.claudio_personagens.bookingcharactersapi.repositories;

import com.claudio_personagens.bookingcharactersapi.base.AbstractRepository;
import com.claudio_personagens.bookingcharactersapi.domain.Client;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClientRepository extends AbstractRepository<Client, String>, JpaSpecificationExecutor<Client> {
}
