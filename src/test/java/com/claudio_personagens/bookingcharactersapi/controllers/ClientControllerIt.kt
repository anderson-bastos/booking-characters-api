package com.claudio_personagens.bookingcharactersapi.controllers

import com.claudio_personagens.bookingcharactersapi.domain.Client
import com.claudio_personagens.bookingcharactersapi.security.jwt.JwtTokenUtil
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Before
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.testcontainers.junit.jupiter.Testcontainers
import javax.transaction.Transactional

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class ClientControllerIt : AbstractControllerIT() {

    @Autowired
    lateinit var mockMvcTest: MockMvc

    @Test
    fun `Should Save a client`(){
        val client = Client(
            "Test",
            "Test_2",
            null
        )

        println(ObjectMapper().writeValueAsString(client))

        this.mockMvcTest.perform(
            MockMvcRequestBuilders.post("${ClientController.URL}")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Test\",\"password\":\"Test_2\",\"addresses\":null}")
                //.content(ObjectMapper().writeValueAsString(client))
            )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isCreated)
            .andReturn()
    }




//    fun save(client: Client): Client
//    fun findByName(name: String): Optional<Client>
//    fun findById(id: UUID): Optional<Client>
//    fun findAll(): List<Client>

}