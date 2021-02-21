package com.claudio_personagens.bookingcharactersapi.controllers;

import org.testcontainers.containers.PostgreSQLContainer;

public class IntegrationPostgresqlContainer extends PostgreSQLContainer<IntegrationPostgresqlContainer> {

    private static final String IMAGE_VERSION = "postgres:10.6";
    private static IntegrationPostgresqlContainer container;

    private IntegrationPostgresqlContainer(){
        super(IMAGE_VERSION);
    }

    public static IntegrationPostgresqlContainer getInstance() {
        if (container == null) {
            container = new IntegrationPostgresqlContainer();
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
