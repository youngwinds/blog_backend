package top.youngwind.blog.dao.user;

import top.youngwind.blog.entity.user.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionDao extends JpaRepository<PermissionEntity, Integer> {
    /**
     * 查询Id在数组内的所有权限
     */
    List<PermissionEntity> findAllByIdIn(List<Integer> ids);
}
