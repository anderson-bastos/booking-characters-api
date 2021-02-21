package com.claudio_personagens.bookingcharactersapi.services;

import com.claudio_personagens.bookingcharactersapi.domain.User;

import java.util.List;

public interface UserService {
    public User salvar(User user);
    public List<User> findAll();

}
