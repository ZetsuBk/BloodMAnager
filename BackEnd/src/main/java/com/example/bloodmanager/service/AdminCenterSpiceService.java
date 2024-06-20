package com.example.bloodmanager.service;

import org.springframework.stereotype.Service;

import com.example.bloodmanager.models.User;
import com.example.bloodmanager.models.User.Role;

@Service
public class AdminCenterSpiceService {

  
    
    public boolean isValid(User user){
        return user.getRole() == Role.ADMINC && user.getCenter() != null;
    }
}
