package com.trilogyed.comment.model;

import java.time.LocalDate;
import java.util.Objects;

public class Comment {

    private int commentId;
    private int postId;
    private LocalDate createDate;
    private String commenterName;
    private String comment;

    public Comment() {
    }

    public Comment(int commentId, int postId, LocalDate createDate, String commenterName, String comment) {
        this.commentId = commentId;
        this.postId = postId;
        this.createDate = createDate;
        this.commenterName = commenterName;
        this.comment = comment;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return getCommentId() == comment1.getCommentId() &&
                getPostId() == comment1.getPostId() &&
                Objects.equals(getCreateDate(), comment1.getCreateDate()) &&
                Objects.equals(getCommenterName(), comment1.getCommenterName()) &&
                Objects.equals(getComment(), comment1.getComment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCommentId(), getPostId(), getCreateDate(), getCommenterName(), getComment());
    }
}
