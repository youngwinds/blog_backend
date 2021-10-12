package top.youngwind.blog.service;

import top.youngwind.blog.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    /**
     * 新增博客
     */
    Article add(Article article);

    /**
     * 修改博客
     */
    Article save(Article article);

    /**
     * 根据Id删除
     */
    void deleteById(Integer id);

    /**
     * 根据Id查询
     */
    Optional<Article> findById(Integer id);

    /**
     * 查询全部博客
     */
    List<Article> findAll();
}
