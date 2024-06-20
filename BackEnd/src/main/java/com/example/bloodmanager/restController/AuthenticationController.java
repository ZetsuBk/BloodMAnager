package com.example.bloodmanager.restController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bloodmanager.dto.AuthenticationResponse;
import com.example.bloodmanager.dto.LoginRequest;
import com.example.bloodmanager.dto.UserRegisterDto;
import com.example.bloodmanager.models.User;
import com.example.bloodmanager.service.AuthenticationService;
import com.example.bloodmanager.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public User register(@RequestBody UserRegisterDto userdDto) {
        User user =  userdDto.Mapp();
        return authenticationService.Register(user);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest request) {
        return authenticationService.login(request);
    }
    
    
    
}
