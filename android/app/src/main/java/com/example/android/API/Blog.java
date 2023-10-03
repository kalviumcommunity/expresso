package com.example.android.API;

public class Blog {
    long blogId;
    String blogTitle;
    String blogContent;
    long createdAt;
    long userId;
    int likes;
    long categoryId;
    public Blog(long blogId, String blogTitle, String blogContent, long createdAt, long userId, int likes, long categoryId) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
        this.createdAt = createdAt;
        this.userId = userId;
        this.likes = likes;
        this.categoryId = categoryId;
    }
    public long getBlogId() {
        return blogId;
    }
    public String getBlogTitle() {
        return blogTitle;
    }
    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }
    public String getBlogContent() {
        return blogContent;
    }
    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }
    public long getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
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
}
