package top.youngwind.blog.dao.user;

import top.youngwind.blog.entity.user.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Young
 * @Description: 测试UserDao的增删改查
 * @Date: create in 2021/1/17 16:33
 */
@SpringBootTest
class UserDaoTest {
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
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("test");
        userEntity.setPassword("123456");
        userEntity.setRole(roleDao.findById(9).orElse(null));
        userDao.save(userEntity);
    }

    /**
     * 删除
     */
    @Test
    @Transactional
    @Rollback(false)
    void delete() {
        userDao.deleteById(9);
    }

    /**
     * 修改
     */
    @Test
    @Transactional
    @Rollback(false)
    void modify() {
        UserEntity userEntity = userDao.findById(9).orElse(null);
        userEntity.setUsername("testModify");
        userEntity.setRole(roleDao.findById(2).orElse(null));
        userDao.save(userEntity);
    }

    /**
     * 查询
     */
    @Test
    @Transactional
    @Rollback(false)
    void query() {
        List<UserEntity> userEntityList = userDao.findAll();
        for (UserEntity userEntity : userEntityList) {
            System.out.println(userEntity.getUsername());
        }

        for (UserEntity user : userDao.findById(9).orElse(null).getRole().getUsers()) {
            System.out.println(user.getUsername());
        }

    }

}