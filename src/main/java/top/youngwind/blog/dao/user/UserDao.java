package top.youngwind.blog.dao.user;

import top.youngwind.blog.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
}
