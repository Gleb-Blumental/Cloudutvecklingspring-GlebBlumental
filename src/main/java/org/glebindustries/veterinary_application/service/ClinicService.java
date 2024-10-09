package org.glebindustries.veterinary_application.service;

import lombok.RequiredArgsConstructor;
import org.glebindustries.veterinary_application.models.Clinic;
import org.glebindustries.veterinary_application.repositories.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClinicService {

    @Autowired
    private final ClinicRepository repository;

    public Iterable<Clinic> getAllClinics() {
        return repository.findAll();
    }


    public boolean createClinic(Clinic clinic) {
        try {
            repository.save(clinic);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateClinic(Long clinicId, Clinic updatedClinic) {
        Optional<Clinic> existingClinic = repository.findById(String.valueOf(clinicId));

        if (existingClinic.isPresent()) {
            Clinic clinic = existingClinic.get();

            clinic.setName(updatedClinic.getName());
            clinic.setAddress(updatedClinic.getAddress());
            clinic.setClients(updatedClinic.getClients());
            updatedClinic.setId(clinicId);
            repository.save(updatedClinic);
            return true;
        }else {
            return false;
        }

    }

    public boolean deleteClinic(Long clinicId) {
        Optional<Clinic> existingClinic = repository.findById(String.valueOf(clinicId));
        if (existingClinic.isPresent()){
            repository.deleteById(String.valueOf(clinicId));
            return true;
            }else {
            return false;
        }
    }

    public Clinic getClinicById(Long clinicId) {
        return repository.findById(String.valueOf(clinicId)).orElse(null);
    }




}
