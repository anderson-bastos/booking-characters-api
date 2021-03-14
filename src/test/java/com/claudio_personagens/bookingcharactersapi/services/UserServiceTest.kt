package com.claudio_personagens.bookingcharactersapi.services

import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class UserServiceTest {
//    @Mock
//    lateinit var userRepository: UserRepository
//
//    @InjectMocks
//    lateinit var userService: UserServiceImpl
//
//    private lateinit var user: User
//
//    @BeforeEach
//    fun init() {
//        user = User(
//            name = "Test",
//            emai
//            password = null,
//            roles = null
//        )
//    }
//
//    @Test
//    @DisplayName("should return user when save")
//    fun save() {
//        Mockito.`when`(userRepository.save<User>(user)).thenReturn(user)
//        val result = userService.save(user)
//        Assertions.assertNotNull(result.id)
//        Assertions.assertEquals(user.name, result.name)
//        Mockito.verify(userRepository, Mockito.times(1)).save<User>(user)
//    }
//
//    @Test
//    @DisplayName("should return a list of users")
//    fun findAll() {
//        val users = listOf(user)
//        Mockito.`when`(
//            userRepository.findAll()
//        ).thenReturn(users)
//        val result = userService.findAll()
//        Assertions.assertFalse(result.isEmpty())
//    }
}