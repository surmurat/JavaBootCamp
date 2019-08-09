package com.trilogyed.commentqueueconsumer;

import com.trilogyed.commentqueueconsumer.dao.CommentServiceClient;
import com.trilogyed.commentqueueconsumer.util.messages.Comment;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageListener {

    private final CommentServiceClient commentServiceClient;

    @Autowired
    public MessageListener(CommentServiceClient commentServiceClient) {
        this.commentServiceClient = commentServiceClient;
    }

    @RabbitListener(queues = CommentQueueConsumerApplication.QUEUE_NAME)
    public void receiveMessage(Comment msg){
        System.out.println(msg.toString());
        // use feign client
        commentServiceClient.addComment(msg);
        }

}
