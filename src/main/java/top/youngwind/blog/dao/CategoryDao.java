package top.youngwind.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.youngwind.blog.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {
}
