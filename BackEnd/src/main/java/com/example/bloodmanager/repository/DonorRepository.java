package com.example.bloodmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bloodmanager.models.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor,Long> {
    
}
