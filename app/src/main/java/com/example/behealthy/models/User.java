package com.example.behealthy.models;

public class User {

    private String userId;
    private String email;
    private String displayName;
    private String password; // For local usage, not recommended to store password in plaintext

    // Default constructor (required for Firebase)
    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    // Constructor for creating a new user during registration
    public User(String userId, String email, String displayName) {
        this.userId = userId;
        this.email = email;
        this.displayName = displayName;
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
