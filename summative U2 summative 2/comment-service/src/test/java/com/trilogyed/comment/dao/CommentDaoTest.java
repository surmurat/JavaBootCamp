package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CommentDaoTest {

    CommentDao dao;

    @Before
    public void setUp() throws Exception {
        List<Comment> commentList = dao.getAllComments();

        commentList.stream()
                .forEach(comment -> dao.deleteComment(comment.getCommentId()));
    }

    @Test
    public void addGetDeleteComment() {
        Comment comment = new Comment();
        comment = dao.addComment(comment);
        Comment fromDao = dao.getComment(comment.getCommentId());
        assertEquals(fromDao,comment);

        dao.deleteComment(comment.getCommentId());
        fromDao = dao.getComment(comment.getCommentId());
        assertNull(fromDao);
    }



    @Test
    public void getAllComments() {
        Comment comment = new Comment();
        dao.addComment(comment);

        comment = new Comment();
        dao.addComment(comment);

        List<Comment> comments = dao.getAllComments();

        assertEquals(2,comments.size());
    }

    @Test
    public void updateComment() {

        Comment comment = new Comment();
        comment = dao.addComment(comment);
        comment.setCommenterName("murat");
        dao.updateComment(comment);
        Comment fromDao = dao.getComment(comment.getCommentId());
        assertEquals(comment,fromDao);
    }


}