package com.claudio_personagens.bookingcharactersapi.services

import com.claudio_personagens.bookingcharactersapi.repositories.UserRepository
import com.claudio_personagens.bookingcharactersapi.security.domain.Role
import com.claudio_personagens.bookingcharactersapi.security.domain.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserServiceImpl (
    private val userRepository: UserRepository
): UserService {

    @Autowired
    private lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder

    @Transactional
    override fun save(user: User): User {
        user.password = bCryptPasswordEncoder.encode(user.password)
        return userRepository.save(user)
    }

    override fun findAll() = userRepository.findAll()

    override fun findByEmail(email: String) = userRepository.findByEmail(email)
}
