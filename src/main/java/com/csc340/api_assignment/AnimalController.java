package com.csc340.api_assignment;

import com.csc340.api_assignment.model.Animal;
import com.csc340.api_assignment.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired // This tag ensures that, through Spring (thanks!) our objects created are automatically injected.
    private AnimalService animalService;

    // Get all animals of every id
    @GetMapping("/all")
    public String getAllStudents(Model model) {
        model.addAttribute("animalList", animalService.getAllAnimals());
        model.addAttribute("title", "All Animals");
        //return service.getAllStudents();
        return "/animal-list";
    }

    // Get mapping for page displaying specific animal
    @GetMapping("/{animalId}")
    public String getOneAnimal(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", animalService.getAnimalById(animalId));
        model.addAttribute("title", "Animal Details - " + animalId); // Setting a more descriptive title
        return "/animal-details";
    }

    // Creating new animal
    @PostMapping("/new")
    public String addNewAnimal(Animal animal) {
        animalService.createAnimal(animal);
        return "redirect:/animals/all";
    }

    @PostMapping("/update/{animalId}")
    public String updateUser(@PathVariable int animalId, @ModelAttribute Animal animal) {
        animalService.updateAnimal(animalId, animal);
        return "redirect:/animals/all";
    }
    @GetMapping("/update/{animalId}")
    public String editAnimal(@PathVariable int animalId, Model model){
        model.addAttribute("animal", animalService.getAnimalById(animalId));
        return "/animal-update";
    }

    // Search by name
    @GetMapping("/search")
    public String getAnimalsByName(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("animalList", animalService.searchAnimalsByName(name));
        return "/animal-list";
    }

    // Delete an animal
    @GetMapping("/delete/{animalId}")
    public String deleteAnimalById(@PathVariable int animalId) {
        animalService.deleteAnimal(animalId);
        return "redirect:/animals/all";
    }
}
