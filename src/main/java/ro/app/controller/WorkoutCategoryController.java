package main.java.ro.app.controller;

import main.java.ro.app.model.WorkoutCategory;
import main.java.ro.app.service.WorkoutCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout-categories")
public class WorkoutCategoryController {

    @Autowired
    private WorkoutCategoryService workoutCategoryService;

    // Get all workout categories
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WorkoutCategory> getAllCategories() {
        return workoutCategoryService.getAllCategories();
    }
}
