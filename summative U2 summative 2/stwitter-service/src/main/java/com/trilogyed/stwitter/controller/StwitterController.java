package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
public class StwitterController {

    @Autowired
    ServiceLayer service;

    @Cacheable
    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public PostViewModel getPost(@PathVariable int id){
        System.out.println("Your Message");
        return service.fetchPost(id);
    }

    @Cacheable
    @RequestMapping(value = "/post/poster/{posterName}", method = RequestMethod.GET)
    public List<PostViewModel> getPostsByPoster(@PathVariable String posterName){

        System.out.println("Your Message");;
        return service.fetchPostsByPoster(posterName);

    }

    @CacheEvict
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public PostViewModel addPost(@RequestBody PostViewModel postViewModel){
        return service.addPost(postViewModel);
    }




}
