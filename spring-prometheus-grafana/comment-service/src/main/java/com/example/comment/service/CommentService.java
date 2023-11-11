package com.example.comment.service;

import com.example.comment.model.Comment;
import io.micrometer.tracing.annotation.NewSpan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommentService {

    private List<Comment> comments = List.of(
            new Comment(1, "nice post 1", 1),
            new Comment(2, "nice post 2", 1),
            new Comment(3, "nice post 3", 1),
            new Comment(4, "nice post 4", 2),
            new Comment(5, "nice post 5", 2),
            new Comment(6, "nice post 6", 3),
            new Comment(7, "nice post 7", 3),
            new Comment(8, "nice post 8", 3),
            new Comment(9, "nice post 9", 4)
    );

    @NewSpan(value = "comment-service-findCommentsByPostId-span")
    public List<Comment> findCommentsByPostId(int postId) {
        return comments.stream().filter(comment -> comment.getPostId() == postId).toList();
    }

}
