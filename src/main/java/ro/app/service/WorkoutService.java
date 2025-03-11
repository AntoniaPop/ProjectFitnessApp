package ro.app.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.app.model.Workout;
import ro.app.repository.WorkoutRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    // Get a workout by ID
    public Optional<Workout> getWorkoutById(Long id) {
        return workoutRepository.findById(id);
    }

    // Get all workouts
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    // Get workout by name
    public Workout getWorkoutByName(String name) {
        return workoutRepository.findByName(name);
    }

    // Create a new workout
    public Workout createWorkout(Workout workout) {
        // Here we simply save the workout using the repository
        return workoutRepository.save(workout);
    }

    // Update an existing workout
    public Workout updateWorkout(Long id, Workout workout) {
        Workout existingWorkout = workoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout not found with ID: " + id));

        // Ensure that the ID is maintained when updating the workout
        workout.setId(existingWorkout.getId());

        // Save and return the updated workout
        return workoutRepository.save(workout);
    }

    // Delete workout by ID
    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }

}
