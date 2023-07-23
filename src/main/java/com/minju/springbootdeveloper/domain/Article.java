package com.minju.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Data
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본생성자
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable=false)
    private Long id;

    @Column(name="title", nullable=false)
    private String title;

    @Column(name="content", nullable=false)
    private String content;

    @CreatedDate //엔티티가 생성될 때 생성된 시간을 저장
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate //엔티티가 수정될 때 마지막으로 수정된 시간을 저장
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}

