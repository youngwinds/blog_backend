package top.youngwind.blog.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import top.youngwind.blog.entity.Article;
import top.youngwind.blog.entity.Category;
import top.youngwind.blog.service.ArticleService;
import top.youngwind.blog.service.CategoryService;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceImplTest {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @Test
    void add() {
        Category category = categoryService.findById(1).orElse(null);


        for (int i = 0; i < 10; i++) {
            Article article = new Article();
            article.setAuthor("author" + i);
            article.setContent("content" + i);
            article.setCoverInfo("coverInfo" + i);
            article.setCoverUrl("coverUrl" + i);
            article.setIntroduce("introduce" + i);
            article.setTitle("title" + i);
            article.setCategory(category);
            articleService.add(article);
        }
    }

    @Test
    @Transactional
    @Rollback(false)
    void save() {
        Category category = categoryService.findById(3).orElse(null);

        Article article = articleService.findById(13).orElse(null);
        if (article != null)
            article.setCategory(category);
        articleService.save(article);
    }

    @Test
    @Transactional()
    @Rollback(false)
    void deleteById() {
        articleService.deleteById(20);
    }

    @Test
    @Transactional
    void findById() {
        System.out.println(articleService.findById(13).orElse(null));
    }

    @Test
    void findAll() {
        System.out.println(articleService.findAll());
    }
}