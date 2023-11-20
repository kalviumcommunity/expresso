package org.example.API;


import org.example.API.Classes.Comment;
import org.example.API.Classes.User;

public class Main {
    public static void main(String[] args) {
        User User1 = new User("Ayush", "ayush.shrivastav@kalvium.com", "Ayush41red", 12345678);
        Comment comment = new Comment(12345678, "Nice comment", 5, 7, 12547850);
        System.out.println(comment.getComment());
        comment.editComment("This is an edited comment");
        System.out.println(comment.getComment());
        System.out.println(User1.getUsername());
    }
}
