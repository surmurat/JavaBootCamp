package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.util.CommentClientService;
import com.trilogyed.stwitter.util.PostClientService;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ServiceLayer serviceLayer;
    PostClientService postClientService;
    CommentClientService commentClientService;
    RabbitTemplate rabbitTemplate;

    @Before
    public void setUp() throws Exception {
        setUpCommentClientMock();
        setUpPostClientMock();
        setUpRabbitTemplateMock();

        serviceLayer = new ServiceLayer(postClientService, commentClientService, rabbitTemplate);
    }

    @Test
    public void addFetchPost() {
        PostViewModel postViewModel = new PostViewModel();
        postViewModel.setPostDate(LocalDate.of(2019,12,12));
        postViewModel.setPosterName("murat");
        postViewModel.setPost("soccer day");

        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,12,12));
        comment.setCommenterName("murat");
        comment.setComment("soccer day");

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);

        postViewModel.setComment(comments);

        postViewModel = serviceLayer.addPost(postViewModel);

        PostViewModel fromService = serviceLayer.fetchPost(postViewModel.getPostID());

        assertEquals(postViewModel,fromService);
    }

    @Test
    public void fetchPostsByPoster() {
        PostViewModel postViewModel = new PostViewModel();



        postViewModel.setPostDate(LocalDate.of(2019,12,12));
        postViewModel.setPosterName("murat");
        postViewModel.setPost("soccer day");

        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,12,12));
        comment.setCommenterName("murat");
        comment.setComment("soccer day");

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);

        postViewModel.setComment(comments);


        postViewModel = serviceLayer.addPost(postViewModel);
        List<PostViewModel> pvm = serviceLayer.fetchPostsByPoster("murat");
        assertEquals(pvm.size(),1);
        assertEquals(pvm.get(0),postViewModel);
    }

    private void setUpCommentClientMock(){
        commentClientService = mock(CommentClientService.class);

        Comment comment = new Comment();
        //include the id
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,12,12));
        comment.setCommenterName("murat");
        comment.setComment("soccer day");

        List<Comment> comments = new ArrayList<>();

        comments.add(comment);

        doReturn(comments).when(commentClientService).getCommentByPostId(1);
    }

    private void setUpPostClientMock(){
        postClientService = mock(PostClientService.class);

        Post post = new Post();
        //set all except for id
        post.setPostDate(LocalDate.of(2019,12,12));
        post.setPosterName("murat");
        post.setPost("soccer day");

        Post post1 = new Post();
        //include the id
        post1.setPostID(1);
        post1.setPostDate(LocalDate.of(2019,12,12));
        post1.setPosterName("murat");
        post1.setPost("soccer day");

        List<Post> posts = new ArrayList<>();

        posts.add(post1);

        doReturn(post1).when(postClientService).createPost(post);
        doReturn(posts).when(postClientService).getPostsByPoster("murat");
        doReturn(post1).when(postClientService).getPost(1);
    }

    private void setUpRabbitTemplateMock(){
        rabbitTemplate = mock(RabbitTemplate.class);
    }
}