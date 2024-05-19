package com.example.bloodmanager.restController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bloodmanager.models.Center;
import com.example.bloodmanager.service.CenterService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class AdminCenterController {

    @Autowired
    private CenterService centerService;

    @GetMapping({"/centers/","/centers"})
    public List<Center> getAll() {
        return centerService.getAll();
    }
    
}
