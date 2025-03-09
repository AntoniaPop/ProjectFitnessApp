package main.java.ro.app.service;

import main.java.ro.app.model.User;
import main.java.ro.app.model.Workout;
import main.java.ro.app.model.UserWorkout;
import main.java.ro.app.repository.UserRepository;
import main.java.ro.app.repository.UserWorkoutRepository;
import main.java.ro.app.repository.WorkoutRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserWorkoutService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private UserWorkoutRepository userWorkoutRepository;

    // Associate a workout with a user
    public UserWorkout addWorkoutToUser(Long userId, Long workoutId, Date date, String workoutStatus) {
        // Make sure userId and workoutId are Long, and we fetch User and Workout
        // correctly
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Workout workout = workoutRepository.findById(workoutId)
                .orElseThrow(() -> new RuntimeException("Workout not found"));

        UserWorkout userWorkout = new UserWorkout(user, workout, date, workoutStatus);

        // Save the UserWorkout to the repository
        return userWorkoutRepository.save(userWorkout);
    }

    // Get a user's workouts by user ID
    public List<UserWorkout> getUserWorkoutsByUser(Long userId) {
        return userWorkoutRepository.findByUserId(userId);
    }

    // Get a users's workouts by workout ID
    public List<UserWorkout> getUserWorkoutsByWorkout(Long workoutId) {
        return userWorkoutRepository.findByWorkoutId(workoutId);
    }

    // Get all user workouts
    public List<UserWorkout> getAllUserWorkouts() {
        return userWorkoutRepository.findAll();
    }

    // Delete a user workout by ID
    public void deleteUserWorkout(Long id) {
        userWorkoutRepository.deleteById(id);
    }

    public void updateOutDatedUserWorkouts(List<UserWorkout> userWorkouts) {
        for (UserWorkout userWorkout : userWorkouts) {
            // Check if the workout is old or needs modification
            if (userWorkout.getStartDate().before(new Date())) {
                // Update the workout to mark it as outdated
                userWorkout.setStatus("Outdated");
                userWorkoutRepository.save(userWorkout);
            }
        }
    }
}
