package top.youngwind.blog.service;

import top.youngwind.blog.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    /**
     * 新增
     */
    Category add(Category category);

    /**
     * 修改
     */
    Category save(Category category);

    /**
     * 根据Id删除
     */
    void deleteById(Integer id);

    /**
     * 根据Id查询
     */
    Optional<Category> findById(Integer id);

    /**
     * 查询全部
     */
    List<Category> findAll();
}
