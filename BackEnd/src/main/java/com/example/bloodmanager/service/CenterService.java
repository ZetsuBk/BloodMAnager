package com.example.bloodmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bloodmanager.models.Center;
import com.example.bloodmanager.repository.CenterRepository;

@Service
public class CenterService {
    
    
    private CenterRepository centerRepository;
    
    public CenterService(CenterRepository centerRepository){
        this.centerRepository = centerRepository;
    }

    public List<Center> getAll(){
        return centerRepository.findAll();
    }
}
