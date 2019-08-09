package com.trilogyed.stwitter.util;

import com.trilogyed.stwitter.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentClientService {


    @GetMapping(value = "comment/post/{postId}")
    public List<Comment> getCommentByPostId(@PathVariable("postId")int postId);

}
