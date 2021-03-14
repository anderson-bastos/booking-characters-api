package com.claudio_personagens.bookingcharactersapi

import org.testcontainers.containers.PostgreSQLContainer

class PostgresqlContainer private constructor() : PostgreSQLContainer<PostgresqlContainer>(IMAGE_VERSION) {

    companion object {
        private const val IMAGE_VERSION = "postgres:10.6"
        private var container: PostgresqlContainer = PostgresqlContainer()
        val instance: PostgresqlContainer
            get() {
                return container
            }
    }

    override fun start() {
        super.start()
        System.setProperty("spring.datasource.url", container.jdbcUrl)
        System.setProperty("spring.datasource.password", container.username)
        System.setProperty("spring.datasource.username", container.password)
    }
}