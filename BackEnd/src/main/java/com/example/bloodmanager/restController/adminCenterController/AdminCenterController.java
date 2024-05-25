package com.example.bloodmanager.restController.adminCenterController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bloodmanager.models.Center;
import com.example.bloodmanager.models.User;
import com.example.bloodmanager.service.CenterService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/adminC")
public class AdminCenterController {

    @Autowired
    private CenterService centerService;

    @GetMapping({"/centers/","/centers"})
    public List<Center> getAll() {
        User  user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("################################"+user.getId());
        return centerService.getAll();
    }
    
}
