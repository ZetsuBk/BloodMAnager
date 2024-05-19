package com.example.bloodmanager.dto;

import com.example.bloodmanager.models.User;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AuthenticationResponse {
    private User user;
    private String token;
}
