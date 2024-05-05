package com.example.bloodmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bloodmanager.models.Center;


@Repository
public interface CenterRepository extends JpaRepository<Center,Long> {
    
}
