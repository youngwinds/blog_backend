package top.youngwind.blog.service;

import top.youngwind.blog.entity.FriendLink;

import java.util.List;
import java.util.Optional;

public interface FriendLinkService {
    /**
     * 新增
     */
    FriendLink add(FriendLink friendLink);

    /**
     * 修改
     */
    FriendLink save(FriendLink friendLink);

    /**
     * 根据Id删除
     */
    void deleteById(Integer id);

    /**
     * 根据Id查询
     */
    Optional<FriendLink> findById(Integer id);

    /**
     * 查询全部
     */
    List<FriendLink> findAll();
}
