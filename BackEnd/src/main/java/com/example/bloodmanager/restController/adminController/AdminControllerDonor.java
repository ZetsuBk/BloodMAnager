package com.example.bloodmanager.restController.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bloodmanager.models.Donor;
import com.example.bloodmanager.responedmodules.Message;
import com.example.bloodmanager.service.DonorService;


@RestController
@RequestMapping("/api/admin/donors")
public class AdminControllerDonor {
     @Autowired
    private DonorService donorService;

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.status(200).body(donorService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        Donor donor = donorService.getDonorByID(id);
        if(donor != null){
            return ResponseEntity.status(200).body(donor);
        }
        return ResponseEntity.status(404).body(Message.writeMessage("Donor not found!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Donor donor = donorService.getDonorByID(id);
        if(donor != null){
            donorService.deleteDonorById(id);
            return ResponseEntity.status(200).body(Message.writeMessage("Donor was deleted succesfuly"));
        }
        return ResponseEntity.status(404).body(Message.writeMessage("Donor not found!"));
    }

    @PostMapping
    public ResponseEntity postMethodName(@RequestBody Donor donor) {
        donorService.saveDonor(donor);
        return ResponseEntity.status(200).body(Message.writeMessage("Donor was save succesfuly"));
    }


    @PutMapping
    public ResponseEntity putMethodName(@RequestBody Donor donorB) {
        Donor donor = donorService.getDonorByID(donorB.getId());
        if(donor != null){
            donorService.saveDonor(donor);
            return ResponseEntity.status(200).body(Message.writeMessage("Donor was update succesfuly"));
        }
        return ResponseEntity.status(404).body(Message.writeMessage("Donor not found!"));
    }
}
