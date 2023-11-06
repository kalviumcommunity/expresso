package org.example.API.Classes;


import org.example.API.Interfaces.UserInterface;

public class User implements UserInterface {
    private static int users = 0;
    private final String email;
    private final long createdAt;
    private String username;
    private String password;

    public User(String username, String email, String password, long createdAt) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        users++;
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

    public int getCountUsers() {
        return users;
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