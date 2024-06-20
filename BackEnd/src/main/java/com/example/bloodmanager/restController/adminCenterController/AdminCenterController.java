package com.example.bloodmanager.restController.adminCenterController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bloodmanager.models.Center;
import com.example.bloodmanager.models.Donor;
import com.example.bloodmanager.models.User;
import com.example.bloodmanager.service.AdminCenterSpiceService;
import com.example.bloodmanager.service.CenterService;
import com.example.bloodmanager.service.DonorService;
import com.example.bloodmanager.service.UserService;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/adminC")
public class AdminCenterController {

    @Autowired
    private DonorService donorService;
    @Autowired
    private AdminCenterSpiceService adminCenterSpiceService;
    @Autowired
    private UserService userService;

    @GetMapping({"/donors/","/donors"})
    public List<Donor> getAll() {
        User  user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (adminCenterSpiceService.isValid(user)){
            return  donorService.getDonorsByCenter(user.getCenter().getId());
        }
        return new ArrayList<>();
    }
    
}
