package top.youngwind.blog.service.user;

import top.youngwind.blog.entity.user.RoleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {
    /**
     * 保存角色
     */
    RoleEntity save(RoleEntity roleEntity);

    /**
     */
    void deleteById(Integer id);

    /**
     * 通过Id查询角色
     */
    RoleEntity findById(Integer id);

    /**
     * 查询全部
     */
    List<RoleEntity> findAll();

    /**
     * 分页查询
     */
    Page<RoleEntity> findAll(Pageable pageable);
}
