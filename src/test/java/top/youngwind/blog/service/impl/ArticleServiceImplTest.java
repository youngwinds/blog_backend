package top.youngwind.blog.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.youngwind.blog.entity.Article;
import top.youngwind.blog.service.ArticleService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceImplTest {
    @Autowired
    private ArticleService articleService;


    @Test
    void add() {
        for (int i = 0; i < 10; i++) {
            Article article = new Article();
            article.setAuthor("author" + i);
            article.setContent("content" + i);
            article.setCoverInfo("coverInfo" + i);
            article.setCoverUrl("coverUrl" + i);
            article.setIntroduce("introduce" + i);
            article.setTitle("title" + i);
            articleService.add(article);
        }
    }

    @Test
    void save() {

    }

    @Test
    void deleteById() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }
}