package com.example.Security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class securityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity HttpSecurity) throws Exception {
        return HttpSecurity
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("v1/index2").permitAll() // Url sin seguridad de acceso
                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .successHandler(successHandler()) // Redireccionar
                        .permitAll())
                .build();

    }

    public AuthenticationSuccessHandler successHandler() {
        return ((requests, response, authentication) -> {
            response.sendRedirect("v1/index");
        });
    }

}
