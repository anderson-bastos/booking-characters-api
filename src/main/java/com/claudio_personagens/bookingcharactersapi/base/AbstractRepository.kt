package com.claudio_personagens.bookingcharactersapi.base

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import java.io.Serializable

@NoRepositoryBean
interface AbstractRepository<T, ID : Serializable?> : JpaRepository<T, ID>