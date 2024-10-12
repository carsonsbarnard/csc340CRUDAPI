package com.csc340.api_assignment.model;
import jakarta.persistence.*;

@Entity
@Table(name = "animals")
public class Animal {
// Our Getters and Setters
    public Animal(Integer animalId, String scientificName, String name, String habitat, String description, String species) {
        this.animalId = animalId;
        this.scientificName = scientificName;
        this.name = name;
        this.habitat = habitat;
        this.description = description;
        this.species = species;
    }

    public Animal(String description, String habitat, String name, String scientificName, String species) {
        this.description = description;
        this.habitat = habitat;
        this.name = name;
        this.scientificName = scientificName;
        this.species = species;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private Integer animalId;

    @Column(name = "description")
    private String description;

    @Column(name = "habitat", nullable = false)
    private String habitat;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "scientific_name")
    private String scientificName;

    @Column(name = "species", nullable = false)
    private String species;

    // Default constructor
    public Animal() {}

    // Getters and Setters
    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
