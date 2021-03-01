package com.claudio_personagens.bookingcharactersapi.controllers

import com.claudio_personagens.bookingcharactersapi.PostgresqlContainer
import org.junit.Before
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class AbstractControllerIT {

    @Autowired
    protected lateinit var context: WebApplicationContext

    @Autowired
    lateinit var mockMvc: MockMvc

    companion object {
        @Container
        var postgreSQLContainer: PostgresqlContainer? = PostgresqlContainer.instance.withReuse(false)
    }

    @Test
    fun containerShouldBeRunning() {
        postgreSQLContainer?.isRunning?.let { Assertions.assertTrue(it) }
    }
}