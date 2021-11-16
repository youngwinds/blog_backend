package top.youngwind.blog.dao.user;

import top.youngwind.blog.entity.user.PermissionEntity;
import top.youngwind.blog.entity.user.RoleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

/**
 * @Author: Young
 * @Description: 测试RoleDao的增删改查
 * @Date: create in 2021/1/17 16:45
 */
@SpringBootTest
class RoleDaoTest {
    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    PermissionDao permissionDao;

    /**
     * 新增
     */
    @Test
    @Transactional
    @Rollback(false)
    void add() {
        RoleEntity roleEntity = new RoleEntity();


        HashSet<PermissionEntity> permissionEntities = new HashSet<>();

        permissionEntities.add(permissionDao.findById(8).orElse(null));
//        permissionEntities.add(permissionDao.findById(9).orElse(null));
//        permissionEntities.add(permissionDao.findById(10).orElse(null));
        permissionEntities.add(permissionDao.findById(11).orElse(null));
        roleEntity.setPermissions(permissionEntities);
        roleEntity.setRoleName("普通管理员");
        roleDao.save(roleEntity);
    }

    /**
     * 删除
     */
    @Test
    @Transactional
    @Rollback(value = false)
    void delete() {
        roleDao.deleteById(10);
    }

    /**
     * 修改
     */
    @Test
    @Transactional
    @Rollback(false)
    void modify() {
        RoleEntity roleEntity = roleDao.findById(5).orElse(null);
        roleEntity.setRoleName(roleEntity.getRoleName()+"测试！！！");
        roleDao.save(roleEntity);
    }

    /**
     * 查询
     */
    @Test
    @Transactional
    @Rollback(false)
    void query() {
        for (RoleEntity entity : roleDao.findAll()) {
            System.out.println(entity.getRoleName());
        }

        for (PermissionEntity permission : roleDao.findById(10).orElse(null).getPermissions()) {
            System.out.println(permission.getPermissionsName());
        }
    }
}