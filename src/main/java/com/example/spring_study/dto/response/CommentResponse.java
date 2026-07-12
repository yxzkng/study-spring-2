package com.example.spring_study.dto.response;

import com.example.spring_study.domain.Comment;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponse {
    private Long articleId;
    private Long commentId;
    private String author;
    private String content;

    public static CommentResponse of(Long articleId, Comment comment) {
        return CommentResponse.builder()
                .articleId(articleId)
                .commentId(comment.getId())
                .author(comment.getAuthor())
                .content(comment.getContent())
                .build();
    }
}