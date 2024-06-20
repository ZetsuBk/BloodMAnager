package com.example.bloodmanager.dto;

import com.example.bloodmanager.models.BloodType;
import com.example.bloodmanager.models.User;
import com.example.bloodmanager.models.User.Role;

import lombok.Data;

@Data
public class UserRegisterDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String cne;
    private Long bloodTypeId;

    public User Mapp(){
        return new User(firstName,lastName,email,password,phoneNumber,cne,new BloodType(bloodTypeId),Role.USER);
    }
}
