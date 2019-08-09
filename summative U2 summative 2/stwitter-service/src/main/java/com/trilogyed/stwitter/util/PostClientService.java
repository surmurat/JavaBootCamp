package com.trilogyed.stwitter.util;


import com.trilogyed.stwitter.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "post-service")
public interface PostClientService {

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Post createPost(@RequestBody Post post);

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable("id") int postId);

    @RequestMapping(value = "/posts/poster/{poster}", method = RequestMethod.GET )
    public List<Post> getPostsByPoster(@PathVariable("poster") String poster);


}
