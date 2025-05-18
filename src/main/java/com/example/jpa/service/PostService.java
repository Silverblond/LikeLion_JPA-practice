package com.example.jpa.service;

import com.example.jpa.dto.Post;
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

    //Post 검색(GET)
    public PostResponseDto getPost(Long id){
        return postRepository.findById(id)
                .map(post -> new PostResponseDto(
                        post.getId(),
                        post.getTitle(),
                        post.getContent(),
                        post.getUser().getUsername()
                ))
                .orElseThrow(() -> new IllegalArgumentException("해당" + id + "의 글을 찾을 수 없습니다."));
    }

    //Post 전체 검색(GET)
    public List<PostResponseDto> getAllPosts(){
        return postRepository.findAll().stream()
                .map(post -> new PostResponseDto(
                        post.getId(),
                        post.getTitle(),
                        post.getContent(),
                        post.getUser().getUsername()
                ))
                .toList();
    }

    //Post 생성(POST)
    public Long creatPost(PostCreateRequestDto dto){
        return userRepository.findById(dto.getUserId())
                .map(user -> {
                    Post post = new Post();
                    post.setTitle(dto.getTitle());
                    post.setContent(dto.getContent());
                    post.setUser(user);
                    return postRepository.save(post).getId();
                })
                .orElseThrow(() -> new IllegalArgumentException("해당" + dto.getUserId() + "의 글을 찾을 수 없습니다."));

    }

}
