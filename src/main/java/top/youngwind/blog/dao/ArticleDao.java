package top.youngwind.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.youngwind.blog.entity.Article;

public interface ArticleDao extends JpaRepository<Article, Integer> {
}
