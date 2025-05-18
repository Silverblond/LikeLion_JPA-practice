package com.example.jpa.controller;

import com.example.jpa.dto.Post;
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

    //POST
    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostCreateRequestDto dto){
        Long id = postService.creatPost(dto);
        return ResponseEntity.ok(id);
    }

    //GET
    @GetMapping
    public ResponseEntity<List<PostResponseDto>> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    //GET-ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id){
        try{
            return ResponseEntity.ok(postService.getPost(id));
        } catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody PostCreateRequestDto dto){
        try{
            PostResponseDto upated = postService.updatePost(id, dto);
            return ResponseEntity.ok(upated);
        } catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    //PATCH
    @PatchMapping("/{id}")
    public ResponseEntity<?> patchPost(@PathVariable Long id, @RequestBody PostCreateRequestDto dto){
        try{
            PostResponseDto patched = postService.patchPost(id, dto);
            return ResponseEntity.ok(patched);
        } catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
