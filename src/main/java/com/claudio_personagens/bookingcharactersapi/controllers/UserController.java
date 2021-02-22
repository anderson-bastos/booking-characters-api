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
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.findAll();
    }
}
