package org.glebindustries.veterinary_application.service;

import lombok.RequiredArgsConstructor;
import org.glebindustries.veterinary_application.models.Animal;
import org.glebindustries.veterinary_application.models.Client;
import org.glebindustries.veterinary_application.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimalService {

    @Autowired
    private final AnimalRepository repository;

    public Iterable<Animal> getAllAnimals() {
        return repository.findAll();
    }

    public Optional<Animal> getAnimalById(Long id) {
        return repository.findById(String.valueOf(id));
    }

    public boolean addAnimal(Animal animal) {
        try {
            repository.save(animal);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Animal updateAnimal(Long id, Animal updatedAnimal) {
        return repository.findById(String.valueOf(id)).map(visit -> {
            visit.setName(updatedAnimal.getName());
            visit.setClient(updatedAnimal.getClient());
            visit.setClinic(updatedAnimal.getClinic());
            visit.setAnimalDiagnosis(updatedAnimal.getAnimalDiagnosis());
            visit.setAnimalTreatment(updatedAnimal.getAnimalTreatment());
            visit.setAnimalTreatmentDate(updatedAnimal.getAnimalTreatmentDate());
            return repository.save(visit);
        }).orElseGet(() -> {
            updatedAnimal.setId(id);
            return repository.save(updatedAnimal);
        });
    }

    public boolean deleteAnimal(Long id) {
        Optional<Animal> existingClient = repository.findById(String.valueOf(id));

        if (existingClient.isPresent()){
            repository.deleteById(String.valueOf(id));
            return true;
        }else {
            return false;
        }
    }



}
