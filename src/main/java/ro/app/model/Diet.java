package main.java.ro.app.model;

import javax.persistence.*;

@Entity
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate unique IDs for Diet entities
    private Long id; // Use Long for auto-generated ids

    private String name; // Name of the diet (e.g., Keto, Vegan, Mediterranean)
    private String description; // Description of the diet

    @ManyToOne // Many Diets can belong to one User
    @JoinColumn(name = "user_id") // This specifies the foreign key column for the User in the Diet table
    private User user; // User who is following the diet

    // Default constructor (required by JPA)
    public Diet() {
    }

    // Constructor with fields
    public Diet(String name, String description, User user) {
        this.name = name;
        this.description = description;
        this.user = user;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Diet{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", user="
                + user + '}';
    }
}
