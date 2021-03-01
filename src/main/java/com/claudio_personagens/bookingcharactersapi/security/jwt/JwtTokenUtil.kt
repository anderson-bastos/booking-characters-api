package com.claudio_personagens.bookingcharactersapi.security.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.springframework.security.core.userdetails.UserDetails
import com.claudio_personagens.bookingcharactersapi.security.jwt.JwtTokenUtil
import com.claudio_personagens.bookingcharactersapi.security.jwt.JwtUser
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.Serializable
import java.lang.Exception
import java.util.*

@Component
class JwtTokenUtil {

    @Value("\${jwt.secret}")
    private lateinit var secret: String

    @Value("\${jwt.jwtExpirationMs}")
    private lateinit var expiration: String

    companion object {
        const val CLAIM_KEY_USERNAME = "sub"
        const val CLAIM_KEY_CREATED = "created"
        const val CLAIM_KEY_EXPIRED = "exp"
    }

    fun getUsernameFromToken(token: String?) =
        kotlin.runCatching {
            val claims = getClaimsFromToken(token)
            claims!!.subject
        }.getOrNull()

    fun getExpirationDateFromToken(token: String) =
        kotlin.runCatching {
            val claims = getClaimsFromToken(token)
            claims!!.expiration
        }.getOrNull()

    private fun getClaimsFromToken(token: String?) =
        kotlin.runCatching {
            Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .body
        }.getOrNull()

    private fun isTokenExpired(token: String) = getExpirationDateFromToken(token)!!.before(Date())

    fun generateToken(userDetails: UserDetails): String {
        val claims: MutableMap<String, Any> = HashMap()
        claims[CLAIM_KEY_USERNAME] = userDetails.username
        val createdDate = Date()
        claims[CLAIM_KEY_CREATED] = createdDate
        return doGenerateToken(claims)
    }

    private fun doGenerateToken(claims: Map<String, Any>?): String {
        val createdDate = claims!![CLAIM_KEY_CREATED] as Date?
        val expirationDate = Date(createdDate!!.time + expiration.toLong() * 1000)
        return Jwts.builder()
            .setClaims(claims)
            .setExpiration(expirationDate)
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact()
    }

    fun canTokenBeRefreshed(token: String) = !isTokenExpired(token)

    fun refreshToken(token: String) =
        kotlin.runCatching {
            val claims = getClaimsFromToken(token)
            claims!![CLAIM_KEY_CREATED] = Date()
            doGenerateToken(claims)
        }.getOrNull()

    fun validateToken(token: String, userDetails: UserDetails): Boolean {
        val user = userDetails as JwtUser
        val username = getUsernameFromToken(token)
        return username == user.username && !isTokenExpired(token)
    }
}