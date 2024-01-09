package io.ssaragi.kotlin.spring.boot.config

import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .csrf { it.disable() }
            .authorizeHttpRequests { request -> request
                .requestMatchers("/*/echo/*")
                .permitAll()
                .anyRequest()
                .authenticated()
            }
            .sessionManagement { session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .exceptionHandling { handler -> handler
                .authenticationEntryPoint { request, response, authException -> response
                    .sendError(HttpServletResponse.SC_NOT_FOUND)
                }
            }
            .build()
    }
}
