package com.example.bloodmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.bloodmanager.models.Center;
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

    public Center getCenterByID(Long id){
        Optional<Center> CenterOp = centerRepository.findById(id) ;
        if(CenterOp.isPresent()){
            return CenterOp.get();
        }
        return null;
        
}

    public void deleteCenterById(Long id){
            centerRepository.deleteById(id);
    }

    public void saveCenter(Center Center){
            centerRepository.save(Center);
    }


    

}
