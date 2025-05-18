package com.example.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor //매개변수가 다 있는 생성자 생성
public class UserDto {
    private String username;
    private String password;
}
