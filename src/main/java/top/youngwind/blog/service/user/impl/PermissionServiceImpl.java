package top.youngwind.blog.service.user.impl;

import top.youngwind.blog.dao.user.PermissionDao;
import top.youngwind.blog.entity.user.PermissionEntity;
import top.youngwind.blog.service.user.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    private PermissionDao permissionDao;

    @Autowired
    public void setUserDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    @Override
    public PermissionEntity save(PermissionEntity permissionEntity) {
        return permissionDao.save(permissionEntity);
    }

    @Override
    public void deleteById(Integer id) {
        permissionDao.deleteById(id);
    }

    @Override
    public PermissionEntity findById(Integer id) {
        return permissionDao.findById(id).orElse(null);
    }

    @Override
    public List<PermissionEntity> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public Page<PermissionEntity> findAll(Pageable pageable) {
        return permissionDao.findAll(pageable);
    }

    @Override
    public List<PermissionEntity> findAllByIdIn(List<Integer> list) {
        return permissionDao.findAllByIdIn(list);
    }
}
