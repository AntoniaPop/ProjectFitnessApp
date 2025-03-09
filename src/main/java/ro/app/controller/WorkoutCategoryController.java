package ro.app.controller;

import ro.app.model.WorkoutCategory;
import ro.app.service.WorkoutCategoryService;
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
