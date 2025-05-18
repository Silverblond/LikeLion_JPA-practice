package com.example.jpa.controller;

import com.example.jpa.dto.PostCreateRequestDto;
import com.example.jpa.dto.PostResponseDto;
import com.example.jpa.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostCreateRequestDto dto){
        Long id = postService.creatPost(dto);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDto>> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id){
        try{
            return ResponseEntity.ok(postService.getPost(id));
        } catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
