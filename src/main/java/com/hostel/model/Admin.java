package com.hostel.model;
import jakarta.persistence.Entity;

@Entity
public class Admin extends User {

    private String role;

    // Default constructor
    public Admin() {
    }

    // Parameterized constructor
    public Admin(Long id, String name, String email, String password, String role) {
        super(id, name, email, password);
        this.role = role;
    }

    // Getters and Setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
