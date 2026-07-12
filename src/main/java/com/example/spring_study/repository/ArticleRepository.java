package com.example.spring_study.repository;

import com.example.spring_study.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ArticleRepository extends JpaRepository<Article,Long> {

}