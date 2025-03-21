package ro.app.repository;

import ro.app.model.UserWorkout;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWorkoutRepository extends JpaRepository<UserWorkout, Long> {

    List<UserWorkout> findByWorkoutId(Long workoutId);

    List<UserWorkout> findByUserId(Long userId);
}