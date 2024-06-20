package com.example.bloodmanager.models;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Center{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String adresse;
    private String email;
    private String phoneNumber;
    
    @Column(columnDefinition = "TIME")
    private LocalTime startTime; 
    @Column(columnDefinition = "TIME")
    private LocalTime endTime; 

    private Boolean openForDonation;

    @ManyToOne
    private City city;
    @OneToMany(mappedBy = "center")
    @JsonIgnore
    private List<Donor> donors;

    

}
