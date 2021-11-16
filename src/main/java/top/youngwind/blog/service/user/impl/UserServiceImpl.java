package top.youngwind.blog.service.user.impl;

import top.youngwind.blog.dao.user.UserDao;
import top.youngwind.blog.entity.user.UserEntity;
import top.youngwind.blog.service.user.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserEntity add(String username, String password) {
        /*
         * MD5加密：
         * 使用Md5Hash类对原始密码进行加密。
         * 第1个参数为原始密码
         * 第2个参数为盐值，即用户名
         * 第3个参数为加密次数
         * */
        String newPassword = new Md5Hash(password,"mshd",1024).toString();

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(newPassword);
        return this.save(userEntity);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userDao.save(userEntity);
    }

    @Override
    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public UserEntity findById(Integer id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }

    @Override
    public Page<UserEntity> findAll(Pageable pageable) {
        return userDao.findAll(pageable);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
