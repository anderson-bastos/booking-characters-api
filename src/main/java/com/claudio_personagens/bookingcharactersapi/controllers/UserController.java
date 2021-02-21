package com.claudio_personagens.bookingcharactersapi.controllers;

import com.claudio_personagens.bookingcharactersapi.domain.User;
import com.claudio_personagens.bookingcharactersapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public @ResponseBody User salvar(@RequestBody User user) {
        return userService.salvar(user);
    }

    @GetMapping("/users")
    public @ResponseBody List<User> getUsers() {
        return userService.findAll();
    }
}
