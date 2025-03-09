package ro.app.repository;

import ro.app.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    // Custom query to find a workout by name
    Workout findByName(String name);

    // Custom query to find all workouts by category
    List<Workout> findByCategory(String category);

}
