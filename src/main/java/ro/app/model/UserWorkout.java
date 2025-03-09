package ro.app.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class UserWorkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;
    private Date startDate; // Date when the user started the workout
    private String status;

    // Constructor, getters, setters
    public UserWorkout(AppUser user, Workout workout, Date startDate, String status) {
        this.user = user;
        this.workout = workout;
        this.startDate = startDate;
        this.status = status;
    }

    // Default constructor for JPA
    public UserWorkout() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserWorkout{" + "id='" + id + '\'' + ", user=" + user.getUsername() + ", workout=" + workout.getName()
                + ", startDate=" + startDate + ", status=" + status + '}';
    }
}
