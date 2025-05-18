package com.example.jpa.dto;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Service
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String username;
    private String password;

    @Builder
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}
