package com.claudio_personagens.bookingcharactersapi.services;

import com.claudio_personagens.bookingcharactersapi.domain.User;
import com.claudio_personagens.bookingcharactersapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User salvar(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}