package com.csc340.api_assignment.service;

import com.csc340.api_assignment.model.Animal;
import com.csc340.api_assignment.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService implements AnimalServiceInterface {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll(); // Uses methods from AnimalRepository
    }

    @Override
    public Optional<Animal> getAnimalById(Integer id) {
        return animalRepository.findById(id);
    }

    @Override
    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal updateAnimal(Integer id, Animal animal) {
        return animalRepository.findById(id)
                .map(existingAnimal -> {
                    existingAnimal.setDescription(animal.getDescription());
                    existingAnimal.setHabitat(animal.getHabitat());
                    existingAnimal.setName(animal.getName());
                    existingAnimal.setScientificName(animal.getScientificName());
                    existingAnimal.setSpecies(animal.getSpecies());
                    return animalRepository.save(existingAnimal);
                })
                .orElse(null);
    }

    @Override
    public void deleteAnimal(Integer id) {
        animalRepository.findById(id).ifPresent(animalRepository::delete);
    }

    @Override
    public List<Animal> getAnimalsBySpecies(String species) {
        return animalRepository.findBySpecies(species);
    }

    @Override
    public List<Animal> searchAnimalsByName(String name) {
        return animalRepository.findByNameContainingIgnoreCase(name);
    }
}
