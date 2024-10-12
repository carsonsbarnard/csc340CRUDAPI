package com.csc340.api_assignment.repository;

import com.csc340.api_assignment.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> findBySpecies(String species);

    List<Animal> findByNameContainingIgnoreCase(String name);
} // JPA Repository has the methods for findAll and what not