package com.example.bloodmanager.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.bloodmanager.config.JwtService;
import com.example.bloodmanager.dto.AuthenticationResponse;
import com.example.bloodmanager.dto.LoginRequest;
import com.example.bloodmanager.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    

    public  AuthenticationResponse login(LoginRequest loginRequest){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword())
            );
        var user = userRepository.findByEmail(loginRequest.getUsername()).get();
        final String token  = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
        .token(token)
        .user(user)
        .build();

    }
}
