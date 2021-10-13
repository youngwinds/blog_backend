package top.youngwind.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.youngwind.blog.entity.FriendLink;

public interface FriendLinkDao extends JpaRepository<FriendLink, Integer> {
}
