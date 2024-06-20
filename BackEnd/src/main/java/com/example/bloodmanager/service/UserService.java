package com.example.bloodmanager.service;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bloodmanager.models.User;
import com.example.bloodmanager.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll().stream().filter(u -> u.getRole() == User.Role.USER ).collect(Collectors.toList());
    }

    public User getUserByID(Long id){
        Optional<User> userOp = userRepository.findById(id) ;
        User user = null;
        if(userOp.isPresent()){
            user = userOp.get();
            if(user !=null){
                return user.getRole() == User.Role.USER ? user : null ;
            }
        }
        return null;
        
    }

    public User getUserByEmail(String email){
        Optional<User> userOp = userRepository.findByEmail(email) ;
        User user = null;
        if(userOp.isPresent()){
            user = userOp.get();
            if(user !=null){
                return user.getRole() == User.Role.USER ? user : null ;
            }
        }
        return null;
        
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }


    public List<User> getAllAdminC(){
        return userRepository.findAll().stream().filter(u -> u.getRole() == User.Role.ADMINC ).collect(Collectors.toList());
    }
    
}
