package ro.app.controller;

import ro.app.model.Workout;
import ro.app.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    // Get a workout by its ID
    @GetMapping("/{id}")
    public Optional<Workout> getWorkoutById(@PathVariable Long id) {
        return workoutService.getWorkoutById(id);
    }

    // Get all workouts
    @GetMapping
    public List<Workout> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    // Create a new workout
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Workout createWorkout(@RequestBody Workout workout) {
        return workoutService.createWorkout(workout);
    }

    // Update an existing workout
    @PutMapping("/{id}")
    public Workout updateWorkout(@PathVariable Long id, @RequestBody Workout workout) {
        return workoutService.updateWorkout(id, workout);
    }

    // Delete a workout by its ID
    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
    }
}
