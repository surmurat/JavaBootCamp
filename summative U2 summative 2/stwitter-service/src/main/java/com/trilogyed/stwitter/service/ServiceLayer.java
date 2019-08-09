package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.util.CommentClientService;
import com.trilogyed.stwitter.util.PostClientService;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceLayer {

private PostClientService postClientService;
private CommentClientService commentClientService;
private RabbitTemplate rabbitTemplate;

    @Autowired
    public ServiceLayer(PostClientService postClientService, CommentClientService commentClientService, RabbitTemplate rabbitTemplate) {
        this.postClientService = postClientService;
        this.commentClientService = commentClientService;
        this.rabbitTemplate = rabbitTemplate;
    }

    public static final String EXCHANGE = "comment-exchange";
    public static final String ROUTING_KEY = "comment.create.service";

    @Transactional
    public PostViewModel addPost(PostViewModel postViewModel) {
        // Persist Book
        Post post = new Post();
        post.setPostDate(postViewModel.getPostDate());
        post.setPosterName(postViewModel.getPosterName());
        post.setPost(postViewModel.getPost());
        // Adding Book to DB
        post = postClientService.createPost(post);
        postViewModel.setPostID(post.getPostID());
        // Persist Notes
        List<Comment> commentList = postViewModel.getComment();
        // Add Book Id to Notes and Persist Notes
        if(commentList!=null){
            commentList.stream()
                    .forEach(comment ->
                    {
                        comment.setPostId(postViewModel.getPostID());
                        System.out.println("Sending posts...");
                        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, comment);
                        System.out.println("Post Sent to Queue for Creation...");
                    });
            // Giving Notes a chance to be saved in DB before retrieving Ids
            simulateSlowService();
            // Getting Notes back from NoteService using Fiegn Client
            postViewModel.setComment(commentClientService.getCommentByPostId(postViewModel.getPostID()));
            return postViewModel;
        } else {
            return postViewModel;
        }
    }


    public PostViewModel fetchPost(int id) {
        Post post = postClientService.getPost(id);
        if(post ==  null)
            return null;
        else
            return buildPostViewModel(postClientService.getPost(id));
    }

    public List<PostViewModel> fetchPostsByPoster(String posterName) {
        List<Post> postList = postClientService.getPostsByPoster(posterName);
        List<PostViewModel> ViewModelList = new ArrayList<>();

        postList.stream()
                .forEach(b -> {
                    PostViewModel bvm = buildPostViewModel(b);
                    ViewModelList.add(bvm);
                });
        return ViewModelList;

    }


    private void simulateSlowService() {
        try {
            long time = 1000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    // Helper methods
    private PostViewModel buildPostViewModel (Post post){
        PostViewModel bvm = new PostViewModel();
        bvm.setPostID(post.getPostID());
        bvm.setPostDate(post.getPostDate());
        bvm.setPosterName(post.getPosterName());
        bvm.setPost(post.getPost());
        bvm.setComment(commentClientService.getCommentByPostId(post.getPostID()));

        return bvm;

    }


}
