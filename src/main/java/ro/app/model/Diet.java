package ro.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate unique IDs for Diet entities
    private Long id;

    private String name;
    private String description;

    @ManyToOne // Many Diets can belong to one User
    @JoinColumn(name = "user_id") // This specifies the foreign key column for the User in the Diet table
    @JsonBackReference //

    private AppUser user; // User who is following the diet

    public Diet() {
    }

    public Diet(String name, String description, AppUser user) {
        this.name = name;
        this.description = description;
        this.user = user;
    }


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

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Diet{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description +  '}';
    }
}
