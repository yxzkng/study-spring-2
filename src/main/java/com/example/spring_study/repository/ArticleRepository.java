package com.example.spring_study.repository;

import com.example.spring_study.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,Long> {
    Optional<Article> findByTitle(String title);
    Optional<Article> findByContent(String content);
    Optional<Article> findByAuthor(String author);

    Optional<Article> findById(Long id);
}