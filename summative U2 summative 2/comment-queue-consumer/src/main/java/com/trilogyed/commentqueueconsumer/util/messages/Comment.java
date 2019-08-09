package com.trilogyed.commentqueueconsumer.util.messages;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.util.Objects;

public class Comment {
    private int commentId;
    private int postId;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate createDate;
    private String commenterName;
    private String comment;


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

    public int getCommentId () {
        return commentId;
    }

    public void setCommentId ( int commentId){
        this.commentId = commentId;
    }

    public int getPostId () {
        return postId;
    }

    public void setPostId ( int postId){
        this.postId = postId;
    }

    public LocalDate getCreateDate () {
        return createDate;
    }

    public void setCreateDate (LocalDate createDate){
        this.createDate = createDate;
    }

    public String getCommenterName () {
        return commenterName;
    }

    public void setCommenterName (String commenterName){
        this.commenterName = commenterName;
    }

    public String getComment () {
        return comment;
    }

    public void setComment (String comment){
        this.comment = comment;
    }


    @Override
    public int hashCode() {
        return Objects.hash(commentId, postId, createDate, commenterName, comment);
    }

    @Override
    public String toString() {
        return "comment{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", createDate=" + createDate +
                ", commenterName='" + commenterName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
