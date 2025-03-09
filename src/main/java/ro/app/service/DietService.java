package main.java.ro.app.service;

import main.java.ro.app.model.Diet;
import main.java.ro.app.repository.DietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DietService {

    @Autowired
    private DietRepository dietRepository;

    // Create a new diet
    public Diet createDiet(Diet diet) {
        return dietRepository.save(diet);
    }

    // Get a diet by ID
    // JpaRepository provides several default methods, including findById() using
    // Optional
    public Optional<Diet> getDietById(Long id) {
        return dietRepository.findById(id);
    }

    // Get all diets
    public List<Diet> getAllDiets() {
        return dietRepository.findAll();
    }

    // Get a diet by name
    public Diet getDietByName(String name) {
        return dietRepository.findByName(name);
    }

    // Update an existing diet
    public Diet updateDiet(Long id, Diet diet) {
        // Fetch the existing diet using findById(), which returns an Optional<Diet>
        Diet existingDiet = dietRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Diet not found with ID: " + id));

        // Ensure that the ID is maintained when updating the diet
        diet.setId(existingDiet.getId());

        // Save and return the updated diet
        return dietRepository.save(diet);
    }

    // Delete diet by ID
    public void deleteDiet(Long id) {
        dietRepository.deleteById(id);
    }
}
