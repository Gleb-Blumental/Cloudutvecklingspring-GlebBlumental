package org.glebindustries.veterinary_application.controllers;

import lombok.RequiredArgsConstructor;
import org.glebindustries.veterinary_application.models.Animal;
import org.glebindustries.veterinary_application.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private final AnimalService animalService;

    @GetMapping("/allanimals")
    public ResponseEntity<Iterable<Animal>> getAllAnimals() {
        var clients = animalService.getAllAnimals();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("getanimal/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Long id) {
        var animal = animalService.getAnimalById(id);

        return animal.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createanimal")
    public ResponseEntity<String> createAnimal(@RequestBody Animal animal) {
        var created = animalService.addAnimal(animal);

        if(created){
            return new ResponseEntity<>("Animal created successfully", HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Error creating animal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateanimal")
    public ResponseEntity<String> updateAnimal (@PathVariable Long id, @RequestBody Animal animal) {
        var updatedAnimal = animalService.updateAnimal(id, animal);
        if (updatedAnimal != null) {
            return new ResponseEntity<>("Animal updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Animal not updated", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteanimal")
    public ResponseEntity<String> deleteAnimal(@PathVariable Long id) {

        var isDeleted = animalService.deleteAnimal(id);

        if (isDeleted) {
            return new ResponseEntity<>("Animal deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Animal not updated", HttpStatus.NOT_FOUND);
        }
    }
}
