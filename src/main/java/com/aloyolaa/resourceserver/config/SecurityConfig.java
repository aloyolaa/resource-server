package com.aloyolaa.resourceserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Value("${jwksUri}")
    private String jwksUri;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.oauth2ResourceServer(
                r -> r.jwt().jwkSetUri("http://localhost:8080/oauth2/jwks")
                        .jwtAuthenticationConverter(new JwtAuthenticationTokenConverter())
        );
        http.authorizeHttpRequests().anyRequest().authenticated();
        return http.build();
    }
}
