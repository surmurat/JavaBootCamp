package com.trilogyed.comment.controller;

import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/comment")
public class CommentServiceController {


    @Autowired
    CommentDao commentDao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment addComment(@RequestBody Comment comment){
        return commentDao.addComment(comment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Comment getComment(@PathVariable int id){
        return commentDao.getComment(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getAllComment(){
        return commentDao.getAllComments();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@PathVariable("id") int commentId, @RequestBody @Valid Comment comment){
        if (comment.getCommentId()==0)
            comment.setCommentId(commentId);
        if ((commentId != comment.getCommentId())){
            throw new IllegalArgumentException("Comment ID on path must match the ID in the Book object");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable("id") int commentId){
        commentDao.deleteComment(commentId);
    }

    @GetMapping(value = "/post/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getCommentByPostId(@PathVariable("postId")int postId){

        return commentDao.getCommentByPostId(postId);
    }
}
