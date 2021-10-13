package top.youngwind.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.youngwind.blog.dao.ArticleDao;
import top.youngwind.blog.dao.CategoryDao;
import top.youngwind.blog.entity.Category;
import top.youngwind.blog.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao;

    @Autowired
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category add(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public Category save(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryDao.deleteById(id);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryDao.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
