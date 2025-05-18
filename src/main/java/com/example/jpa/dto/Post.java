package com.example.jpa.dto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC) //원래 PROTECTED였는데 생성자 만들기 위해서 PUBLIC으로 수정함 -> creatPost(PostService.java)
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

//    @Builder
//    public Post(User user, String title, String content) {
//        this.user = user;
//        this.title = title;
//        this.content = content;
//    }
//
//    public void update(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }
//이전에 적어두라해서 적어둔건데, 하다보니 사용안하게 되었습니다.

    //Post : User = N : 1
    @ManyToOne(fetch = FetchType.LAZY) //LAZY : 지연 로딩
    @JoinColumn(name = "user_id") //외래 키 이름 명시
    private User user;
}
