package com.claudio_personagens.bookingcharactersapi.controllers;

import com.claudio_personagens.bookingcharactersapi.PostgresqlContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AbstractControllerIT {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractControllerIT.class);

    @Container
    public static PostgreSQLContainer postgreSQLContainer = PostgresqlContainer.getInstance()
            .withReuse(false);

    @Autowired
    public TestRestTemplate testRestTemplate;

    @Test
    void containerShouldBeRunning() {
        Assertions.assertTrue(postgreSQLContainer.isRunning());
    }
}
