package top.youngwind.blog.service;

import top.youngwind.blog.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    /**
     * 新增
     */
    Article add(Article article);

    /**
     * 新增文章并且设置分裂
     */
    Article add(Article article,Integer categoryId);

    /**
     * 修改
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
     * 查询全部
     */
    List<Article> findAll();

    /**
     * 根据文章Id查询分类
     */
    List<Article> findAllByCategoryId(Integer categoryId);
}
