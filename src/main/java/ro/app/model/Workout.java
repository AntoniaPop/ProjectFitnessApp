package ro.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private WorkoutCategory category;
    private String description;
    private int durationInMinutes;
    private int caloriesBurned;
    private LocalDateTime workoutDateTime; // Date and time when the workout was performed

    @ManyToMany(mappedBy = "workout") // This maps the UserWorkout relationship
    @JsonBackReference
    private List<UserWorkout> userWorkouts; // Lista de utilizatori care au efectuat acest antrenament

    public Workout() {
    }

    public Workout(Long id, String name, WorkoutCategory category, String description, int durationInMinutes,
            int caloriesBurned, LocalDateTime workoutDateTime) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.durationInMinutes = durationInMinutes;
        this.caloriesBurned = caloriesBurned;
        this.workoutDateTime = workoutDateTime;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkoutCategory getCategory() {
        return category;
    }

    public void setCategory(WorkoutCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public LocalDateTime getWorkoutDateTime() {
        return workoutDateTime;
    }

    public void setWorkoutDateTime(LocalDateTime workoutDateTime) {
        this.workoutDateTime = workoutDateTime;
    }

    public List<UserWorkout> getUserWorkouts() {
        return userWorkouts;
    }

    public void setUserWorkouts(List<UserWorkout> userWorkouts) {
        this.userWorkouts = userWorkouts;
    }

    @Override
    public String toString() {
        return "Workout{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", category=" + category + ", description='"
                + description + '\'' + ", durationInMinutes=" + durationInMinutes + ", caloriesBurned=" + caloriesBurned
                + ", workoutDateTime=" + workoutDateTime + ", userWorkouts='" + userWorkouts + '\'' + '}';
    }
}