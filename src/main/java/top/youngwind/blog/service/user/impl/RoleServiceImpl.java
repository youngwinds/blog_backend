package top.youngwind.blog.service.user.impl;

import top.youngwind.blog.dao.user.RoleDao;
import top.youngwind.blog.entity.user.RoleEntity;
import top.youngwind.blog.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    @Autowired
    public void setUserDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public RoleEntity save(RoleEntity roleEntity) {
        return roleDao.save(roleEntity);
    }

    @Override
    public void deleteById(Integer id) {
        roleDao.deleteById(id);
    }

    @Override
    public RoleEntity findById(Integer id) {
        return roleDao.findById(id).orElse(null);
    }

    @Override
    public List<RoleEntity> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Page<RoleEntity> findAll(Pageable pageable) {
        return roleDao.findAll(pageable);
    }
}
