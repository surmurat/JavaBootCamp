package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostDao dao;

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post) {
        return dao.addPost(post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Post getPost(@PathVariable("id") int postId) {
        Post postViewModel = dao.getPost(postId);
        if (postViewModel == null)
            throw new IllegalArgumentException("Posts could not be retrieved for id " + postId);
        return postViewModel;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@RequestBody Post postViewModel, @PathVariable int postId) {
        if (postViewModel.getPostID() == 0)
            postViewModel.setPostID(postId);
        if (postId != postViewModel.getPostID()){
            throw new IllegalArgumentException("Post ID on path must match the ID in the Post object");
        }
        dao.updatePost(postViewModel);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int postId) {
        dao.deletePost(postId);
    }

    @RequestMapping(value = "/posts/poster/{poster}", method = RequestMethod.GET )
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getPostsByPoster(@PathVariable("poster") String poster) {
        List<Post> post = dao.getPostsByPoster(poster);
        if (post != null && post.size() == 0)
            throw new IllegalArgumentException("Post could not be retrieved for posts " + poster);
        return post;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET )
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getAllPosts() {
        return dao.getAllPost();
    }
}
