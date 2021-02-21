package com.claudio_personagens.bookingcharactersapi.repositories;

import com.claudio_personagens.bookingcharactersapi.base.AbstractRepository;
import com.claudio_personagens.bookingcharactersapi.domain.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends AbstractRepository<User, String>, JpaSpecificationExecutor<User> {
}
