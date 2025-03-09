package main.java.ro.app.controller;

import main.java.ro.app.model.UserWorkout;
import main.java.ro.app.service.UserWorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/userworkouts")
public class UserWorkoutController {

    @Autowired
    private UserWorkoutService userWorkoutService;

    // Create a new UserWorkout (Associate a workout with a user)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserWorkout addWorkoutToUser(@RequestParam Long userId, @RequestParam Long workoutId,
            @RequestParam Date date, @RequestParam String status) {
        return userWorkoutService.addWorkoutToUser(userId, workoutId, date, status);
    }

    // Get all workouts of a user by user ID
    @GetMapping("/user/{userId}")
    public List<UserWorkout> getUserWorkouts(@PathVariable Long userId) {
        return userWorkoutService.getUserWorkoutsByUser(userId);
    }

    // Get all workouts associated with a specific workout by workout ID
    @GetMapping("/workout/{workoutId}")
    public List<UserWorkout> getWorkoutsByWorkout(@PathVariable Long workoutId) {
        return userWorkoutService.getUserWorkoutsByWorkout(workoutId);
    }

    // Get all user workouts
    @GetMapping
    public List<UserWorkout> getAllUserWorkouts() {
        return userWorkoutService.getAllUserWorkouts();
    }

    // Delete a user workout by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserWorkout(@PathVariable Long id) {
        userWorkoutService.deleteUserWorkout(id);
    }

    // Optional: Update outdated user workouts based on the start date
    @PutMapping("/updateOutdated")
    public void updateOutdatedUserWorkouts() {
        userWorkoutService.updateOutDatedUserWorkouts();
    }
}
