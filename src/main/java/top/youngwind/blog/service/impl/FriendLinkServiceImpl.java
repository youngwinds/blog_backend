package top.youngwind.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.youngwind.blog.dao.FriendLinkDao;
import top.youngwind.blog.entity.FriendLink;
import top.youngwind.blog.service.FriendLinkService;

import java.util.List;
import java.util.Optional;

@Service
public class FriendLinkServiceImpl implements FriendLinkService {
    private FriendLinkDao friendLinkDao;

    @Autowired
    public void setFriendLinkDao(FriendLinkDao friendLinkDao) {
        this.friendLinkDao = friendLinkDao;
    }

    @Override
    public FriendLink add(FriendLink friendLink) {
        return friendLinkDao.save(friendLink);
    }

    @Override
    public FriendLink save(FriendLink friendLink) {
        return friendLinkDao.save(friendLink);
    }

    @Override
    public void deleteById(Integer id) {
        friendLinkDao.deleteById(id);
    }

    @Override
    public Optional<FriendLink> findById(Integer id) {
        return friendLinkDao.findById(id);
    }

    @Override
    public List<FriendLink> findAll() {
        return friendLinkDao.findAll();
    }
}
