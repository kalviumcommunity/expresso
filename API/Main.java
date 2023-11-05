package org.example.API;


import org.example.API.Classes.User;

public class Main {
    public static void main(String[] args) {
        User User1 = new User("Ayush", "ayush.shrivastav@kalvium.com", "Ayush41red", 12345678);
        User User2 = new User("Sidhant", "siddhant9504@gmail.com", "sidd9504", 1245785);
        User User3 = new User("Akanksha", "akanksha23123@gmail.com", "vanshbishnoi0029", 45612378);
//        System.out.println(User1.getUsername() + " " + User2.getUsername() + " " + User3.getUsername());
        System.out.println(User3.getCountUsers());
    }
}
