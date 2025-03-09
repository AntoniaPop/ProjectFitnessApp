package main.java.ro.app.controller;

import main.java.ro.app.model.Diet;
import main.java.ro.app.service.DietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/diets")
public class DietController {

    @Autowired
    private DietService dietService;

    // Create a new diet
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Diet createDiet(@RequestBody Diet diet) {
        return dietService.createDiet(diet);
    }

    // Update an existing diet
    @PutMapping("/{id}")
    public Diet updateDiet(@PathVariable Long id, @RequestBody Diet diet) {
        return dietService.updateDiet(id, diet);
    }

    // Get a diet by ID
    @GetMapping("/{id}")
    public Optional<Diet> getDiet(@PathVariable Long id) {
        return dietService.getDietById(id);
    }

    // Get all diets
    @GetMapping
    public List<Diet> getAllDiets() {
        return dietService.getAllDiets();
    }

    // Delete a diet by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDiet(@PathVariable Long id) {
        dietService.deleteDiet(id);
    }
}
