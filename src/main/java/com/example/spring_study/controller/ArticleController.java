package com.example.spring_study.controller;

import com.example.spring_study.dto.request.ArticleRequest;
import com.example.spring_study.dto.request.UpdateArticleRequest;
import com.example.spring_study.dto.response.ApiResponse;
import com.example.spring_study.dto.response.ArticleDetailResponse;
import com.example.spring_study.dto.response.ArticleSummaryResponse;
import com.example.spring_study.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aritlces")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping()
    public ResponseEntity<ApiResponse<ArticleDetailResponse>> addArticle(@RequestBody ArticleRequest request) {
        ArticleDetailResponse articleResponse = articleService.addArticle(request.getTitle(), request.getContent(), request.getAuthor(), request.getPassword());

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(201, "게시글 생성 성공", articleResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ArticleDetailResponse>> getOneArticle(@PathVariable Long id) {
        ArticleDetailResponse articleResponse = articleService.getOneArticle(id);
        return ResponseEntity.ok(ApiResponse.success(200, "게시글 개별 조회에 성공하였습니다.", articleResponse));
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<ArticleSummaryResponse>>> getArticles() {
        List<ArticleSummaryResponse> articleDetailResponses = articleService.getArticles();
        return ResponseEntity.ok(ApiResponse.success(200,"게시글 전체 조회에 성공하였습니다.", articleDetailResponses));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<ArticleDetailResponse>> updateArticle(@PathVariable Long id, @RequestBody UpdateArticleRequest request) {
        ArticleDetailResponse articleDetailResponse = articleService.updateArticle(id, request.getTitle(), request.getContent());
        return ResponseEntity.ok(ApiResponse.success(200, "게시물을 업데이트 하였습니다.", articleDetailResponse));
    }
}
