package com.example.bloodmanager.restController.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.bloodmanager.models.Center;
import com.example.bloodmanager.models.User;
import com.example.bloodmanager.responedmodules.Message;
import com.example.bloodmanager.service.CenterService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/admin/centers")
public class AdminControllerCenters {
    
    @Autowired
    private CenterService centerService;

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.status(200).body(centerService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        Center center = centerService.getCenterByID(id);
        if(center != null){
            return ResponseEntity.status(200).body(center);
        }
        return ResponseEntity.status(404).body(Message.writeMessage("Center not found!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Center center = centerService.getCenterByID(id);
        if(center != null){
            centerService.deleteCenterById(id);
            return ResponseEntity.status(200).body(Message.writeMessage("Center was deleted succesfuly"));
        }
        return ResponseEntity.status(404).body(Message.writeMessage("Center not found!"));
    }

    @PostMapping
    public ResponseEntity postMethodName(@RequestBody Center center) {
        centerService.saveCenter(center);
        return ResponseEntity.status(200).body(Message.writeMessage("Center was save succesfuly"));
    }


    @PutMapping
    public ResponseEntity putMethodName(@RequestBody Center centerB) {
        Center center = centerService.getCenterByID(centerB.getId());
        if(center != null){
            centerService.saveCenter(center);
            return ResponseEntity.status(200).body(Message.writeMessage("Center was update succesfuly"));
        }
        return ResponseEntity.status(404).body(Message.writeMessage("Center not found!"));
    }


}
