package ro.app.repository;

import ro.app.model.Diet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietRepository extends JpaRepository<Diet, Long> {
    // Custom query methods can be added here if needed, e.g., findByName
    // "SELECT * FROM DIETS WHERE NAME = 'name'"
    Diet findByName(String name);
}
