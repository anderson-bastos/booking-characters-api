package com.claudio_personagens.bookingcharactersapi.services;

import com.claudio_personagens.bookingcharactersapi.domain.Client;
import com.claudio_personagens.bookingcharactersapi.domain.User;
import com.claudio_personagens.bookingcharactersapi.repositories.ClientRepository;
import com.claudio_personagens.bookingcharactersapi.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    public void init(){
        user = User.builder()
                .name("Test")
                .password("Test")
                .build();
    }

    @Test
    @DisplayName("should return user when save")
    public void save(){
        Mockito.when(userRepository.save(user)).thenReturn(user);

        User result = userService.save(user);

        Assertions.assertNotNull(result.getId());
        Assertions.assertEquals(user.getName(), result.getName());
        Assertions.assertEquals(user.getPassword(), result.getPassword());
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    @DisplayName("should return a list of users")
    public void findAll(){
        List<User> users = List.of(user);

        Mockito.when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.findAll();
        Assertions.assertFalse(result.isEmpty());
    }
}
