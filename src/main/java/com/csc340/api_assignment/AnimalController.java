package com.csc340.api_assignment;

import com.csc340.api_assignment.model.Animal;
import com.csc340.api_assignment.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AnimalController {

    @Autowired // This tag ensures that, through Spring (thanks!) our objects created are automatically injected.
    private AnimalService animalService;

    // Get all animals of every id
    @GetMapping("/animals")
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    // Get animal by ID (make sure you know your id you are searching)
    @GetMapping("/animals/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Integer id) {
        Optional<Animal> animal = animalService.getAnimalById(id);
        return animal.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Creates a new animal in the API at the last id possible (e.g. if we have 3 ids, next will be 4)
    @PostMapping("/animals")
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
        Animal savedAnimal = animalService.createAnimal(animal);
        return new ResponseEntity<>(savedAnimal, HttpStatus.CREATED);
    }

    // Update an existing animal in the API
    @PutMapping("/animals/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Integer id, @RequestBody Animal animal) {
        Animal updatedAnimal = animalService.updateAnimal(id, animal);
        return updatedAnimal != null ? new ResponseEntity<>(updatedAnimal, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get animals by species
    @GetMapping("/animals/species/{species}")
    public List<Animal> getAnimalsBySpecies(@PathVariable String species) {
        return animalService.getAnimalsBySpecies(species);
    }

    // Search animals by the name tag using strings (e.g. "?name=bear" if you are looking for types of bears)
    @GetMapping("/animals/search")
    public List<Animal> searchAnimalsByName(@RequestParam String name) {
        return animalService.searchAnimalsByName(name);
    }

    // Deletes an animal, I noticed that the id is left behind though
    @DeleteMapping("/animals/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Integer id) {
        Optional<Animal> animal = animalService.getAnimalById(id);
        if (animal.isPresent()) {
            animalService.deleteAnimal(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
