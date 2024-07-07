
package com.example.bloodmanager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bloodmanager.models.Blood;
import com.example.bloodmanager.repository.BloodRepository;
import com.example.bloodmanager.repository.DonorRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class DashbordAdminService {
    
    private final BloodRepository bloodRepository;
    private final com.example.bloodmanager.repository.UserRepository UserRepository;
    private final DonorRepository donorRepository;


    public HashMap<String,Float> getBloodStat(){
            List<Blood> blooList =  bloodRepository.findAll();
            List<Blood> bloodListA = blooList.stream().filter(blood -> blood.getBloodType().getNom().equals("A+") || blood.getBloodType().getNom().equals("A-")  ).toList();
            List<Blood> bloodListB = blooList.stream().filter(blood -> blood.getBloodType().getNom().equals("B+") || blood.getBloodType().getNom().equals("B-")  ).toList();
            List<Blood> bloodListAB = blooList.stream().filter(blood -> blood.getBloodType().getNom().equals("AB+") || blood.getBloodType().getNom().equals("AB-")  ).toList();
            List<Blood> bloodListO = blooList.stream().filter(blood -> blood.getBloodType().getNom().equals("O+") || blood.getBloodType().getNom().equals("O-")  ).toList();
            
            HashMap<String,Float> res = new HashMap<>();
            res.put("A", (bloodListA.size()*100f)/blooList.size());
            res.put("B", (bloodListB.size()*100f)/blooList.size());
            res.put("O", (bloodListO.size()*100f)/blooList.size());
            res.put("AB", (bloodListAB.size()*100f)/blooList.size());

            return res; 
    }


    public HashMap<String,Double> getBloodUnit(){
        List<Blood> blooList =  bloodRepository.findAll();
        List<Blood> bloodListA = blooList.stream().filter(blood -> blood.getBloodType().getNom().equals("A+") || blood.getBloodType().getNom().equals("A-")  ).toList();
        List<Blood> bloodListB = blooList.stream().filter(blood -> blood.getBloodType().getNom().equals("B+") || blood.getBloodType().getNom().equals("B-")  ).toList();
        List<Blood> bloodListAB = blooList.stream().filter(blood -> blood.getBloodType().getNom().equals("AB+") || blood.getBloodType().getNom().equals("AB-")  ).toList();
        List<Blood> bloodListO = blooList.stream().filter(blood -> blood.getBloodType().getNom().equals("O+") || blood.getBloodType().getNom().equals("O-")  ).toList();
        
        HashMap<String,Double> res = new HashMap<>();
        res.put("A", bloodListA.stream().mapToDouble(Blood::getStock).sum());
        res.put("B", bloodListB.stream().mapToDouble(Blood::getStock).sum());
        res.put("O", bloodListO.stream().mapToDouble(Blood::getStock).sum());
        res.put("AB",bloodListAB.stream().mapToDouble(Blood::getStock).sum());

        return res; 
    }

    public HashMap<String,Double> getStat(){
            HashMap<String,Double> res = new HashMap<>();
            res.put("totalUsers",UserRepository.findAll().size()* 1d);
            res.put("totaldonors",donorRepository.findAll().size()* 1d);
            res.put("totalYongUsers",UserRepository.findAll().stream().filter(user -> user.getAge() >=18 && user.getAge() <= 30 ).toList().size()*1d);
            return res;
    }

}