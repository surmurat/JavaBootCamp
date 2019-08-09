package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;

import java.util.List;

public interface PostDao {

    public Post addPost(Post post);
    public Post getPost(int id);
    public List<Post> getAllPost();
    public void updatePost(Post post);
    public void deletePost(int id);
    public List<Post> getPostsByPoster(String poster);
}
