package com.example.bloodmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bloodmanager.models.Center;
import com.example.bloodmanager.repository.CenterRepository;

@Service
public class CenterService {
    
    @Autowired
    private CenterRepository centerRepository;

    public List<Center> getAll(){
        return centerRepository.findAll();
    }
}
