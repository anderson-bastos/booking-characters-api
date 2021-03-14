package com.claudio_personagens.bookingcharactersapi.config

import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import kotlin.Throws
import java.io.IOException
import javax.servlet.*
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletRequest

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
class CorsFilter : Filter {

    override fun doFilter(req: ServletRequest, res: ServletResponse, chain: FilterChain) {
        val response = res as HttpServletResponse
        val request = req as HttpServletRequest
        val origin = request.getHeader("Origin")
        response.setHeader("Access-Control-Allow-Credentials", "true")
        response.setHeader("Access-Control-Allow-Origin", "*")
        response.setHeader("Vary", "Origin")
        response.setHeader("Access-Control-Allow-Methods", "*")
        response.setHeader(
            "Access-Control-Allow-Headers",
            "Origin, X-Requested-With, Authorization, Content-Type, Accept, X-CSRF-TOKEN"
        )
        response.setHeader("Access-Control-Max-Age", "3600")
        if ("OPTIONS".equals(req.method, ignoreCase = true)) {
            response.status = HttpServletResponse.SC_OK
        } else {
            chain.doFilter(req, res)
        }
    }

    override fun destroy() {}

    override fun init(config: FilterConfig) {
    }
}