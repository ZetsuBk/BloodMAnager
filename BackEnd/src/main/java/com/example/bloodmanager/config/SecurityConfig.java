package com.example.bloodmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeHttpRequests((authorize) ->
                authorize.requestMatchers("/api/**").permitAll().anyRequest().permitAll()
        ).formLogin().permitAll().and().logout().permitAll();
                
        return http.build();
    }
}

//new-update coming from 2025
