package ro.app.service;

import ro.app.model.AppUser;
import ro.app.model.Workout;
import ro.app.model.UserWorkout;
import ro.app.repository.UserRepository;
import ro.app.repository.UserWorkoutRepository;
import ro.app.repository.WorkoutRepository;

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
        AppUser user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

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
            if (userWorkout.getStartDate().before(new Date())) {
                userWorkout.setStatus("Outdated");
                userWorkoutRepository.save(userWorkout);
            }
        }
    }
}
