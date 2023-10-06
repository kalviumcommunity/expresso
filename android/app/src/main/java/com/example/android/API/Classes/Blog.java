package com.example.android.API.Classes;

import com.example.android.API.Interfaces.BlogInterface;

public class Blog implements BlogInterface {
    private static int numberOfBlogs = 0;
    private final long blogId;
    private String blogTitle;
    private String blogContent;
    private final long createdAt;
    private final long userId;
    private int likes;
    private final long categoryId;

    public Blog(long blogId, String blogTitle, String blogContent, long createdAt, long userId, int likes, long categoryId) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
        this.createdAt = createdAt;
        this.userId = userId;
        this.likes = likes;
        this.categoryId = categoryId;
        numberOfBlogs++;
    }

    public long getBlogId() {
        return blogId;
    } 

    public String getBlogTitle() {
        return blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUserId() {
        return userId;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public int getBlogsCount() {
        return numberOfBlogs;
    }

    @Override
    public void editTitle(String newTitle) {
        this.blogTitle = newTitle;
    }

    @Override
    public void editContent(String newContent) {
        this.blogContent = newContent;
    }
}
