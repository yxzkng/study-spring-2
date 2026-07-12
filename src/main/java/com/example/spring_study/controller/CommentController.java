package com.example.spring_study.controller;

import com.example.spring_study.dto.request.CommentRequest;
import com.example.spring_study.dto.response.ApiResponse;
import com.example.spring_study.dto.response.CommentResponse;
import com.example.spring_study.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{articleId}/comments")
    public ResponseEntity<ApiResponse<CommentResponse>> addComment(@RequestBody CommentRequest commentRequest, @PathVariable Long articleId) {
        CommentResponse commentResponse = commentService.addComment(commentRequest.getContent(), commentRequest.getAuthor(), articleId);
        return ResponseEntity.ok(ApiResponse.success(201, "댓글 생성에 성공하였습니다.", commentResponse));
    }

    @GetMapping("/{articleId}/comments")
    public ResponseEntity<ApiResponse<List<CommentResponse>>> addComment(@PathVariable Long articleId) {
        List<CommentResponse> commentResponses = commentService.getComments(articleId);
        return ResponseEntity.ok(ApiResponse.success(200, "댓글 조회에 성공하였습니다.", commentResponses));
    }

}