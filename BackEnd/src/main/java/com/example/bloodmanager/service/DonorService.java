package com.example.bloodmanager.service;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bloodmanager.models.Donor;
import com.example.bloodmanager.repository.DonorRepository;

@Service
public class DonorService {
    @Autowired
    private DonorRepository donorRepository;

    public List<Donor> getAll(){
        return donorRepository.findAll();
    }

    public Donor getDonorByID(Long id){
        Optional<Donor> DonorOp = donorRepository.findById(id) ;
        if(DonorOp.isPresent()){
            return DonorOp.get();
        }
        return null;
        
    }

    public void deleteDonorById(Long id){
            donorRepository.deleteById(id);
    }

    public void saveDonor(Donor Donor){
            donorRepository.save(Donor);
    }

    public List<Donor> getDonorsByCenter(long id){
        return donorRepository.findAllByCenterId(id);
    }

}
