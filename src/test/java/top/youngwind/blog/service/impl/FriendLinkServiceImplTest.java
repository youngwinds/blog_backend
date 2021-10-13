package top.youngwind.blog.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.youngwind.blog.entity.FriendLink;
import top.youngwind.blog.service.FriendLinkService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FriendLinkServiceImplTest {
    @Autowired
    private FriendLinkService friendLinkService;

    @Test
    void add() {
        for (int i = 0; i < 10; i++) {
            FriendLink friendLink = new FriendLink();
            friendLink.setName("youngwind"+i);
            friendLink.setUrl("youngwind.top"+i);
            friendLinkService.add(friendLink);
        }
    }

    @Test
    void save() {
        FriendLink friendLink = friendLinkService.findById(21).orElse(null);
        if (friendLink != null)
            friendLink.setName("new +++");
        friendLinkService.save(friendLink);
    }

    @Test
    void deleteById() {
        friendLinkService.deleteById(21);
    }

    @Test
    void findById() {
        System.out.println(friendLinkService.findById(1).orElse(null));
    }

    @Test
    void findAll() {
        System.out.println(friendLinkService.findAll());
    }
}