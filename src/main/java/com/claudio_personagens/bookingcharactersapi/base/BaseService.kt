package com.claudio_personagens.bookingcharactersapi.base

import java.util.*

interface BaseService<T, ID> {
    fun save(t: T): T
    fun findById(id: ID): Optional<T>
    fun findAll(): MutableList<T>
    fun deleteById(id: ID)
}