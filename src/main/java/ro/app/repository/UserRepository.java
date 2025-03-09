package ro.app.repository;

import ro.app.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    // Custom query methods can be added here if needed, e.g., findByUsername
    AppUser findByUsername(String username);
}