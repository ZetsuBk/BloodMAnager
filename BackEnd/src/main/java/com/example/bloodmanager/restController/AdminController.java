package com.example.bloodmanager.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bloodmanager.models.User;
import com.example.bloodmanager.responedmodules.Message;
import com.example.bloodmanager.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping({"/users","/users/"})
    public List<User> getUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/users/{id}")
    public Object getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserByID(id);
        return user != null ? user : ResponseEntity.status(404).body(Message.writeMessage("User not found!"))   ;
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.status(200).body(Message.writeMessage("User was deleted succesfuly"));
    }

   @PostMapping({"/users","/users/"})
   public ResponseEntity postMethodName(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.status(200).body(Message.writeMessage("User was save succesfuly"));
    }


}
   
    





