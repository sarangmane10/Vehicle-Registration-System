package com.projects.vehicle.registration.model;

import jakarta.persistence.*; 




@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    
    private String role;

    public User() {}

    public User(String email, String password, String roles) {
        this.email = email;
        this.password = password;
        this.role = roles;
    }

    // getters only (no setters if you prefer constructor-only)

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRoles() {
        return role;
    }
    
}

