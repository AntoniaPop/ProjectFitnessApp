package main.java.ro.app.service;

import main.java.ro.app.model.WorkoutCategory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class WorkoutCategoryService {

    // Get all workout categories
    public List<WorkoutCategory> getAllCategories() {
        return Arrays.asList(WorkoutCategory.values());
    }
}
