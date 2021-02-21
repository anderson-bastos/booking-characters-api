package com.claudio_personagens.bookingcharactersapi.controllers;

import com.claudio_personagens.bookingcharactersapi.domain.User;
import com.claudio_personagens.bookingcharactersapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public @ResponseBody
    User salvar(@RequestBody User user) {
        return clientService.save(user);
    }

    @GetMapping
    public @ResponseBody
    List<User> getUsers() {
        return clientService.findAll();
    }
}
