package com.claudio_personagens.bookingcharactersapi;

import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresqlContainer extends PostgreSQLContainer<PostgresqlContainer> {

    private static final String IMAGE_VERSION = "postgres:10.6";
    private static PostgresqlContainer container;

    private PostgresqlContainer(){
        super(IMAGE_VERSION);
    }

    public static PostgresqlContainer getInstance() {
        if (container == null) {
            container = new PostgresqlContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("spring.datasource.url", container.getJdbcUrl());
        System.setProperty("spring.datasource.password", container.getUsername());
        System.setProperty("spring.datasource.username", container.getPassword());
    }
}
