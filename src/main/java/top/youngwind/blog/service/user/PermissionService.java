package top.youngwind.blog.service.user;

import top.youngwind.blog.entity.user.PermissionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PermissionService {
    /**
     * 保存权限
     */
    PermissionEntity save(PermissionEntity permissionEntity);

    /**
     * 通过Id删除权限
     */
    void deleteById(Integer id);

    /**
     * 通过Id查询权限
     */
    PermissionEntity findById(Integer id);

    /**
     * 查询全部
     */
    List<PermissionEntity> findAll();

    /**
     * 分页查询
     */
    Page<PermissionEntity> findAll(Pageable pageable);

    /**
     * 找到全部在list中的权限
     */
    List<PermissionEntity> findAllByIdIn(List<Integer> list);
}
