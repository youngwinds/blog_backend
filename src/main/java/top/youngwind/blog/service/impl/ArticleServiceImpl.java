package top.youngwind.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.youngwind.blog.dao.ArticleDao;
import top.youngwind.blog.dao.CategoryDao;
import top.youngwind.blog.entity.Article;
import top.youngwind.blog.entity.Category;
import top.youngwind.blog.service.ArticleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleDao articleDao;
    private CategoryDao categoryDao;

    @Autowired
    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Autowired
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Article add(Article article) {
        return articleDao.save(article);
    }

    @Override
    public Article add(Article article, Integer categoryId) {
        if (categoryId != null) {
            article.setCategory(categoryDao.findById(categoryId).orElse(null));
        }
        return articleDao.save(article);
    }

    @Override
    public Article save(Article article) {
        return articleDao.save(article);
    }

    @Override
    public void deleteById(Integer id) {
        articleDao.deleteById(id);
    }

    @Override
    public Optional<Article> findById(Integer id) {
        return articleDao.findById(id);
    }

    @Override
    public List<Article> findAll() {
        return articleDao.findAll();
    }

    @Override
    public List<Article> findAllByCategoryId(Integer categoryId) {
        Category category = categoryDao.findById(categoryId).orElse(null);
        if (category != null)
            return new ArrayList<>(category.getArticleSet());
        return null;
    }
}
