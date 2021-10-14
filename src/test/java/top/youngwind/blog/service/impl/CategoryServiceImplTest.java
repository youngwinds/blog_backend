package top.youngwind.blog.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import top.youngwind.blog.entity.Category;
import top.youngwind.blog.service.CategoryService;

import javax.transaction.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    void add() {
        for (int i = 0; i < 10; i++) {
            Category category = new Category();
            category.setName("category" + i);
            categoryService.add(category);
        }
    }

    @Test
    @Transactional()
    @Rollback(false)
    void save() {
        Category category = categoryService.findById(3).orElse(null);
        if (category != null)
            category.setName("new +++");
        categoryService.save(category);
    }

    @Test
    @Transactional()
    @Rollback(false)
    void deleteById() {
        categoryService.deleteById(2);
    }

    @Test
    void findById() {
        System.out.println(categoryService.findById(3).orElse(null));
    }

    @Test
    void findAll() {
        System.out.println(categoryService.findAll());
    }

}