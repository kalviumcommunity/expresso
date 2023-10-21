package org.example.API;


import org.example.API.Classes.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("bisf", "ishbifb", "oiaubfw", 5656244);
        System.out.println(user.getCountUsers());
    }
}
