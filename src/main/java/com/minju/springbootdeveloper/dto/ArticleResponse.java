package com.minju.springbootdeveloper.dto;

import com.minju.springbootdeveloper.domain.Article;
import lombok.Getter;

@Getter
//응답을 위한 dto
public class ArticleResponse {

    private final String title;
    private final String content;

    public ArticleResponse(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
