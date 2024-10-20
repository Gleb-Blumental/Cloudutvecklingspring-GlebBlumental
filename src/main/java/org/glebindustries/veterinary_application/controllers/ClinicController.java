package org.glebindustries.veterinary_application.controllers;

import lombok.AllArgsConstructor;
import org.glebindustries.veterinary_application.models.Clinic;
import org.glebindustries.veterinary_application.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/clinic")
public class ClinicController {
    @Autowired
    private final ClinicService clinicService;

    @GetMapping
    public String clinicPage() {
        return "clinic";
    }

    @PostMapping("/addclinic")
    public ResponseEntity<String> createClinic(Clinic clinic){
        var created = clinicService.createClinic(clinic);

        if(created){
            return new ResponseEntity<>("Clinic created successfully", HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Error creating clinic", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



    @PutMapping("/updateclinic")
    public ResponseEntity<String> updateClinic(@PathVariable Long clinicId, @RequestBody Clinic clinic){
        var updated = clinicService.updateClinic(clinicId, clinic);

        if(updated){
            return new ResponseEntity<>("Clinic updated successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Error updating clinic", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteclinic")
    public ResponseEntity<String> deleteClinic(@PathVariable Long clinicId){
        var deleted = clinicService.deleteClinic(clinicId);

        if(deleted){
            return new ResponseEntity<>("Clinic deleted successfully", HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>("Error deleting clinic", HttpStatus.NOT_FOUND);
        }
    }


}
