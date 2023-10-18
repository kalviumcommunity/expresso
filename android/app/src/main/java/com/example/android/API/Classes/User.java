package com.example.android.API.Classes;

import com.example.android.API.Interfaces.UserInterface;

public class User implements UserInterface {
    private long userId;
    private String username;
    private final String email;
    private String password;
    private final long createdAt;

    public User(long userId, String username, String email, String password, long createdAt) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    @Override
    public void changeUserName(String newUserName) {
        this.username = newUserName;
    }

    @Override
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    @Override
    public boolean toggleDarkMode(boolean darkModeState) {
        darkModeState = !darkModeState;
        return darkModeState;
    }
}