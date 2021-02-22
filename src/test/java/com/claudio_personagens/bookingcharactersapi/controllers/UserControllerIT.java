package com.claudio_personagens.bookingcharactersapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.transaction.Transactional;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class UserControllerIT extends  AbstractControllerIT {

    @Test
    public void loginWithAdminUser() throws Exception {
        HashMap<String, String> login = getUser("admin", "123456");
        ResponseEntity<String> result  = testRestTemplate
                .postForEntity("/auth", new ObjectMapper().writeValueAsString(login), String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
    }

    @Test
    public void loginWithUserNotAllowed() throws Exception {
        HashMap<String, String> login = getUser("admin-test", "password-test");

        ResponseEntity<String> result  = testRestTemplate
                .postForEntity("/auth", new ObjectMapper().writeValueAsString(login), String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
    }

    private HashMap<String, String> getUser(String admin, String password) {
        HashMap<String, String> login = new HashMap<>();
        login.put("username", admin);
        login.put("password", password);
        return login;
    }
}
