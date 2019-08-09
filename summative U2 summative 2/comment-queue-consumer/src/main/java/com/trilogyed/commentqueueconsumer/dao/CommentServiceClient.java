package com.trilogyed.commentqueueconsumer.dao;


import com.trilogyed.commentqueueconsumer.util.messages.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "comment-service")
public interface CommentServiceClient {

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public void addComment(Comment comment);
}
