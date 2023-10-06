package com.example.android.API;

public class Comment {
    long commentId;
    String comment;
    long blogId;
    long userId;
    long commentedAt;

    public Comment(long commentId, String comment, long blogId, long userId, long commentedAt) {
        this.commentId = commentId;
        this.comment = comment;
        this.blogId = blogId;
        this.userId = userId;
        this.commentedAt = commentedAt;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getCommentId() {
        return commentId;
    }

    public long getBlogId() {
        return blogId;
    }

    public long getUserId() {
        return userId;
    }
}
