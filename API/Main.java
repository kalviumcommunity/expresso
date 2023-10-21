package org.example.API;


import org.example.API.Classes.User;

public class Main {
    public static void main(String[] args) {
        User[] user = new User[3];
        user[1] = new User("Ayush6041", "ayush.shrivastav@kalvium.com", "Ayush41red", 12345678);
        user[2] = new User("Sidhant", "siddhant9504@gmail.com", "sidd9504", 1245785);
        user[0] = new User("Akanksha", "akanksha23123@gmail.com", "vanshbishnoi0029", 45612378);
//        System.out.println(user[2].getUsername());
        System.out.println(user[1].getCountUsers());
    }
}
