package com.example.jpa.service;

import com.example.jpa.dto.User;
import com.example.jpa.dto.UserDto;
import com.example.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    //User 검색(GET)
    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당" + id + "의 유저를 찾을 수 없습니다."));
    }

    //User 전체 검색(GET)
    public List<User> getUser(){
        return userRepository.findAll();
    }

    //User 생성(CREATE,POST)
    @Transactional //트랜젝션, 하나로 묶음, 하나라도 실패하면 롤백
    public User createUser(UserDto userDto){
        User user = User.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .build();

        return userRepository.save(user);
    }

    //User 업데이트(PUT)
    @Transactional
    public User updateUser(Long id, UserDto userDto){
        //해당 Id의 User를 찾지 못할 경우 예외
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당" + id + "의 유저를 찾을 수 없습니다."));

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        return user;
    }

    //User 부분 업데이트(PATCH)
    @Transactional
    public User patchUser(Long id, UserDto userDto){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당" + id + "의 유저를 찾을 수 없습니다."));

        if(userDto.getUsername() != null){
            user.setUsername(userDto.getUsername());
        }

        if(userDto.getPassword() != null){
            user.setPassword(userDto.getPassword());
        }
        return user;
    }

    //User 삭제(DELETE)
    @Transactional
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
