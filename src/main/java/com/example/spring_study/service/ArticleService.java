package com.example.spring_study.service;

import com.example.spring_study.domain.Article;
import com.example.spring_study.dto.response.ApiResponse;
import com.example.spring_study.dto.response.ArticleDetailResponse;
import com.example.spring_study.dto.response.ArticleSummaryResponse;
import com.example.spring_study.repository.ArticleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public ArticleDetailResponse addArticle(String title, String content, String author, String password) {
        Article article = new Article(title, content, author, password);

        articleRepository.save(article);
        return ArticleDetailResponse.from(article);
    }

    @Transactional(readOnly = true)
    public ArticleDetailResponse getOneArticle(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("해당 ID의 게시물을 찾을 수 없습니다."));
        return ArticleDetailResponse.from(article);
    }

    @Transactional(readOnly = true)
    public List<ArticleSummaryResponse> getArticles() {
        List<Article> articles = articleRepository.findAll();
        List<ArticleSummaryResponse> articleResponses = articles.stream()
                .map(ArticleSummaryResponse::from)
                .toList();
        return articleResponses;
    }

    @Transactional
    public ArticleDetailResponse updateArticle(Long id, String title, String content) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("해당 id의 게시글을 찾을 수 없습니다."));

        article.update(title, content);

        articleRepository.save(article);
        return ArticleDetailResponse.from(article);
    }

}
