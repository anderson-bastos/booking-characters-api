package com.claudio_personagens.bookingcharactersapi.controllers

import com.claudio_personagens.bookingcharactersapi.PostgresqlContainer
import com.claudio_personagens.bookingcharactersapi.security.jwt.JwtTokenUtil
import com.claudio_personagens.bookingcharactersapi.security.jwt.JwtUser
import com.claudio_personagens.bookingcharactersapi.security.model.CurrentUser
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Before
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.MediaType
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import java.util.HashMap

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc(addFilters = false)
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

    fun currentUserAdmin(): CurrentUser? {
        val login = getUser("anderson@test.com", "admin")
        val response = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/auth")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(ObjectMapper().writeValueAsString(login))
                )
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
        return ObjectMapper().readValue(response.response.contentAsString, CurrentUser::class.java)
    }

    fun getUser(admin: String, password: String): HashMap<String, String> {
        val login = HashMap<String, String>()
        login["email"] = admin
        login["password"] = password
        return login
    }
}