package com.minju.springbootdeveloper.service;

import com.minju.springbootdeveloper.domain.Article;
import com.minju.springbootdeveloper.dto.AddArticleRequest;
import com.minju.springbootdeveloper.dto.UpdateArticleRequest;
import com.minju.springbootdeveloper.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor //final 또는 @NotNull 붙은 필드를 생성자로 만듦
@Service
public class BlogService {

    private final BlogRepository blogRepository; //내가 예전에 @Autowired 하던 거 저 위에 @Required 뭐시기로 대체 가능

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found: "+ id));
    }

    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found: "+id));

        article.update(request.getTitle(), request.getContent());

        return article;

    }


}
