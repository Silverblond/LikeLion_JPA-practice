package com.example.jpa.service;

import com.example.jpa.dto.PostCreateRequestDto;
import com.example.jpa.dto.PostResponseDto;
import com.example.jpa.repository.PostRepository;
import com.example.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    //
    public PostResponseDto getPost(Long id){

    }

    public List<PostResponseDto> getAllPosts(){

    }

    public Long creatPost(PostCreateRequestDto dto){

    }

}
