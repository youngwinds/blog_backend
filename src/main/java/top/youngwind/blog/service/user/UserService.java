package top.youngwind.blog.service.user;

import top.youngwind.blog.entity.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    /**
     * 添加用户并且对密码加密
     */
    UserEntity add(String username,String password);

    /**
     * 保存用户
     */
    UserEntity save(UserEntity userEntity);

    /**
     * 通过Id删除用户
     */
    void deleteById(Integer id);

    /**
     * 通过Id查询用户
     */
    UserEntity findById(Integer id);

    /**
     * 查询全部
     */
    List<UserEntity> findAll();

    /**
     * 分页查询
     */
    Page<UserEntity> findAll(Pageable pageable);

    /**
     * 通过用户名查询用户
     */
    UserEntity findByUsername(String username);
}
