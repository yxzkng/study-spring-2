package com.example.spring_study.service;

import com.example.spring_study.domain.Article;
import com.example.spring_study.domain.Comment;
import com.example.spring_study.dto.response.CommentResponse;
import com.example.spring_study.repository.ArticleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    public CommentResponse addComment(String content, String author, Long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new EntityNotFoundException("해당 ID의 게시글을 찾을 수 없습니다."));

        Comment comment = new Comment(author, content, article);
        commentRepository.save(comment);
        CommentResponse response = CommentResponse.of(article.getId(), comment);
        return response;
    }
}
