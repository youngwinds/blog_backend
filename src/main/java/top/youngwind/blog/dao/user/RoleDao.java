package top.youngwind.blog.dao.user;

import top.youngwind.blog.entity.user.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<RoleEntity, Integer> {

}
