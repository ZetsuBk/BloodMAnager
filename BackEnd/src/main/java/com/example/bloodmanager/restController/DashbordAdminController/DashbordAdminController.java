package com.example.bloodmanager.restController.DashbordAdminController;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bloodmanager.service.DashbordAdminService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class DashbordAdminController {

    private final DashbordAdminService dashbordAdminService ;

    @GetMapping("/totalunits")
    public HashMap<String,Double> getMethodName() {
        return dashbordAdminService.getBloodUnit() ;
    }

    @GetMapping("/percentage")
    public HashMap<String,Float> getPercentage() {
        return dashbordAdminService.getBloodStat() ;
    }

    @GetMapping("/stat")
    public HashMap<String,Double> getstat() {
        return dashbordAdminService.getStat() ;
    }
    
}
