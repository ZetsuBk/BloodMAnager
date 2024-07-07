package com.example.bloodmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bloodmanager.models.Blood;

public interface BloodRepository extends JpaRepository<Blood,Long>{
    
}   
