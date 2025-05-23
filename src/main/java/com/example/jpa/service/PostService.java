package com.example.jpa.service;

import com.example.jpa.dto.Post;
import com.example.jpa.dto.PostCreateRequestDto;
import com.example.jpa.dto.PostResponseDto;
import com.example.jpa.repository.PostRepository;
import com.example.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Long creatPost(PostCreateRequestDto dto){
        return userRepository.findById(dto.getUserId())
                .map(user -> {
                    Post post = new Post();
                    post.setTitle(dto.getTitle());
                    post.setContent(dto.getContent());
                    post.setUser(user); //작성자
                    return postRepository.save(post).getId(); //DB에 저장 후 ID 반환
                })
                .orElseThrow(() -> new IllegalArgumentException("해당" + dto.getUserId() + "의 글을 찾을 수 없습니다."));

    }

    //Post 수정(PUT)
    @Transactional
    public PostResponseDto updatePost(Long id, PostCreateRequestDto dto){
        return postRepository.findById(id)
                .map(post -> {
                    post.setTitle(dto.getTitle()); //제목 덮어쓰기
                    post.setContent(dto.getContent()); //내용 덮어 쓰기
                    post.setUser(userRepository.findById(dto.getUserId())
                            .orElseThrow(() -> new IllegalArgumentException("해당 id의 유저를 찾을 수 없습니다.")));

                    return new PostResponseDto( //DTO로 반환
                            post.getId(),
                            post.getTitle(),
                            post.getContent(),
                            post.getUser().getUsername()
                    );
                })
        .orElseThrow(() -> new IllegalArgumentException("해당" + id + "의 글을 찾을 수 없습니다."));
    }

    //Post 일부 수정(PATCH)
    @Transactional
    public PostResponseDto patchPost(Long id, PostCreateRequestDto dto){
        return postRepository.findById(id)
                .map(post -> {
                    if(dto.getTitle() != null)
                        post.setTitle(dto.getTitle()); //제목만 수정 가능
                    if(dto.getContent() != null)
                        post.setContent(dto.getContent()); //내용만 수정 가능
                    if(dto.getUserId() != null){
                        post.setUser(userRepository.findById(dto.getUserId())
                                .orElseThrow(() -> new IllegalArgumentException("해당 id의 유저를 찾을 수 없습니다.")));
                    }
                    return new PostResponseDto(
                            post.getId(),
                            post.getTitle(),
                            post.getContent(),
                            post.getUser().getUsername()
                    );
                })
                .orElseThrow(() -> new IllegalArgumentException("해당" + id + "의 글을 찾을 수 없습니다."));
    }

    //Post 삭제(DELETE)
    @Transactional
    public void deletePost(Long id){
        postRepository.delete(postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당" + id + "의 글을 찾을 수 없습니다.")));
    }
}
