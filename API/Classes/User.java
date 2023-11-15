package org.example.API.Classes;

import org.example.API.Interfaces.UserInterface;

// Abstract class providing common behavior
abstract class AbstractUser implements UserInterface {
    protected String username;
    protected String password;

    public AbstractUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void changeUserName(String newUserName) {
        this.username = newUserName;
    }

    @Override
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public String getUsername() {
        return username;
    }
}

public class User extends AbstractUser {
    private static int users = 0;
    private final String email;
    private final long createdAt;

    public User(String username, String email, String password, long createdAt) {
        super(username, password); // Call the constructor of the abstract class
        this.email = email;
        this.createdAt = createdAt;
        users++;
    }

    public static int getCountUsers() {
        return users;
    }

    public String getEmail() {
        return email;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean toggleDarkMode(boolean darkModeState) {
        darkModeState = !darkModeState;
        return darkModeState;
    }
}
