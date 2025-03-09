package ro.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the user (Changed to Long for typical ID handling)

    private String username; // Username for login
    private String firstName; // User's first name
    private String lastName; // User's last name
    private String email; // User's email address

    // One-to-many relationship: User can have many diets
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Diet> diets;

    // One-to-many relationship: User can have many user workouts
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference // Prevent recursion by excluding the 'user' field when serializing Diet
    private List<UserWorkout> userWorkouts;

    // Default constructor (required by JPA)
    public AppUser() {
    }

    // Constructor with parameters (you can add userWorkouts here as well)
    public AppUser(String username, String firstName, String lastName, String email, List<Diet> diets,
                   List<UserWorkout> userWorkouts) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.diets = diets;
        this.userWorkouts = userWorkouts;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Diet> getDiets() {
        return diets;
    }

    public void setDiets(List<Diet> diets) {
        this.diets = diets;
    }

    public List<UserWorkout> getUserWorkouts() {
        return userWorkouts;
    }

    public void setUserWorkouts(List<UserWorkout> userWorkouts) {
        this.userWorkouts = userWorkouts;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", diets=" + diets + ", userWorkouts="
                + userWorkouts + '}';
    }
}
