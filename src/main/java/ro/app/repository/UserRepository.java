package main.java.ro.app.repository;

import main.java.ro.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods can be added here if needed, e.g., findByUsername
    User findByUsername(String username);
}