package ro.app.service;

import ro.app.model.Diet;
import ro.app.repository.DietRepository;
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
        Diet existingDiet = dietRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Diet not found with ID: " + id));

        diet.setId(existingDiet.getId());

        return dietRepository.save(diet);
    }

    // Delete diet by ID
    public void deleteDiet(Long id) {
        dietRepository.deleteById(id);
    }
}
