package org.example.API.Classes;

import org.example.API.Interfaces.CommentInterface;

public class Comment implements CommentInterface {
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

    public long getCommentId() {
        return commentId;
    }

    public long getBlogId() {
        return blogId;
    }

    public long getUserId() {
        return userId;
    }

    @Override
    public void editComment(String newComment) {
        this.comment = newComment;
    }
}
