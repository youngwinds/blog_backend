package top.youngwind.blog.dao.user;

import top.youngwind.blog.entity.user.PermissionEntity;
import top.youngwind.blog.entity.user.RoleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Young
 * @Description:
 * @Date: create in 2021/1/17 18:30
 */
@SpringBootTest
class PermissionDaoTest {
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
        PermissionEntity permissionEntity1 = new PermissionEntity();
        permissionEntity1.setPermissionsName("新增");
        permissionDao.save(permissionEntity1);
        PermissionEntity permissionEntity2 = new PermissionEntity();
        permissionEntity2.setPermissionsName("删除");
        permissionDao.save(permissionEntity2);
        PermissionEntity permissionEntity3 = new PermissionEntity();
        permissionEntity3.setPermissionsName("修改");
        permissionDao.save(permissionEntity3);
        PermissionEntity permissionEntity4 = new PermissionEntity();
        permissionEntity4.setPermissionsName("查询");
        permissionDao.save(permissionEntity4);
    }

    /**
     * 删除
     */
    @Test
    @Transactional
    @Rollback(false)
    void delete() {
        permissionDao.deleteById(6);
    }

    /**
     * 修改
     */
    @Test
    @Transactional
    @Rollback(false)
    void modify() {
        PermissionEntity permissionEntity = permissionDao.findById(6).orElse(null);
        permissionEntity.setPermissionsName("测试权限2修改");
        permissionDao.save(permissionEntity);
    }

    /**
     * 查询
     */
    @Test
    @Transactional
    @Rollback(false)
    void query() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        for (PermissionEntity entity : permissionDao.findAllByIdIn(list)) {
            System.out.println(entity.getPermissionsName());
        }
        ;

        for (PermissionEntity permissionEntity : permissionDao.findAll()) {
            System.out.println(permissionEntity.getPermissionsName());
        }

        for (PermissionEntity permissionEntity : permissionDao.findAll()) {
            for (RoleEntity role : permissionEntity.getRoles()) {
                System.out.println(role.getRoleName());
            }

        }

    }

}