package ro.app.service;

import ro.app.model.AppUser;
import ro.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create a new user
    public AppUser createUser(AppUser user) {
        return userRepository.save(user);
    }

    // Get user by ID
    public Optional<AppUser> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Get all users
    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by username
    public AppUser getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public AppUser updateUser(Long id, AppUser user) {
        // Fetch the existing user using findById(), which returns an Optional<User>
        AppUser existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

        // Ensure that the ID is maintained when updating the user
        user.setId(existingUser.getId());

        // Save and return the updated user
        return userRepository.save(user);
    }

    // Delete user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
