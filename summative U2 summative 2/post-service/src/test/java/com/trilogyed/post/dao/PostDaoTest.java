package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostDaoTest {

    @Autowired
    PostDao dao;

    @Before
    public void setUp() throws Exception {

        List<Post> postList = dao.getAllPost();

        postList.stream()
                .forEach(post -> dao.deletePost(post.getPostID()));
    }

    @Test
    public void addGetDeletePost() {

        Post post = new Post(LocalDate.of(2019,12,12),"murat","homework");
        post= dao.addPost(post);
        Post fromDao = dao.getPost(post.getPostID());
        assertEquals(fromDao,post);

        dao.deletePost(post.getPostID());
        fromDao = dao.getPost(post.getPostID());
        assertNull(fromDao);
    }



    @Test
    public void getAllPost() {

        Post post = new Post(LocalDate.of(2019,11,11),"surenler","summative");
        dao.addPost(post);

        post = new Post(LocalDate.of(2019,7,6),"serdar","Germany");
        dao.addPost(post);

        List<Post> posts =dao.getAllPost();

        assertEquals(2,posts.size());
    }

    @Test
    public void updatePost() {
        Post post = new Post(LocalDate.of(2019,1,1),"cenk","Berlin");
        post = dao.addPost(post);
        post.setPosterName("murat");
        dao.updatePost(post);
        Post fromDao = dao.getPost(post.getPostID());
        assertEquals(post,fromDao);
    }


}