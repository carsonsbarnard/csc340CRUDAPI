package com.csc340.api_assignment.service;

import com.csc340.api_assignment.model.Animal;

import java.util.List;
import java.util.Optional;
// Interface to make the AnimalService class less messy
public interface AnimalServiceInterface {
    List<Animal> getAllAnimals();
    Animal getAnimalById(Integer id);
    Animal createAnimal(Animal animal);
    Animal updateAnimal(Integer id, Animal animal);
    void deleteAnimal(Integer id);
    List<Animal> getAnimalsBySpecies(String species);
    List<Animal> searchAnimalsByName(String name);
}
