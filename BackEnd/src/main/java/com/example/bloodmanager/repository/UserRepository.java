package com.example.bloodmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bloodmanager.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
