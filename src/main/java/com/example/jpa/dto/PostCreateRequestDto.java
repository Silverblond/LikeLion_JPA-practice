package com.example.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostCreateRequestDto {
    private String title;
    private String content;
    private Long userId;
}
