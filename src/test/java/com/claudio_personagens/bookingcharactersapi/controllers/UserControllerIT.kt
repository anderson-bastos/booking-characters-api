package com.claudio_personagens.bookingcharactersapi.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Assert
import org.junit.Before
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.testcontainers.junit.jupiter.Testcontainers
import java.util.*
import javax.transaction.Transactional

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class UserControllerIT : AbstractControllerIT() {

    @Test
    fun loginWithAdminUser() {
        val login = getUser("anderson@test.com", "admin")
        this.mockMvc.perform(
            MockMvcRequestBuilders.post("/api/auth")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ObjectMapper().writeValueAsString(login))
            )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isUnauthorized)
            .andReturn()
    }

    @Test
    fun loginWithUserNotAllowed() {
        val login = getUser("admin-test@test.com", "password")
        this.mockMvc.perform(
            MockMvcRequestBuilders.post("/api/auth")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ObjectMapper().writeValueAsString(login))
            )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isUnauthorized)
            .andReturn()
    }

    private fun getUser(admin: String, password: String): HashMap<String, String> {
        val login = HashMap<String, String>()
        login["email"] = admin
        login["password"] = password
        return login
    }
}