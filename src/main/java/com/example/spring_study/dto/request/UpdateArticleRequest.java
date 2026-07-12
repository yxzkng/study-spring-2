package com.example.spring_study.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class UpdateArticleRequest {
    String title;
    String content;
    String password;
}
