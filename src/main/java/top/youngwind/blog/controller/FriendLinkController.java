package top.youngwind.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.youngwind.blog.entity.FriendLink;
import top.youngwind.blog.enums.ResultVOEnum;
import top.youngwind.blog.service.FriendLinkService;
import top.youngwind.blog.vo.ResultVO;

import java.util.List;

@Api(tags = "友情链接")
@RestController
@RequestMapping("/friend_link")
@CrossOrigin(origins = "*")
public class FriendLinkController {
    private FriendLinkService friendLinkService;

    @Autowired
    public void setFriendLinkService(FriendLinkService friendLinkService) {
        this.friendLinkService = friendLinkService;
    }

    @Operation(summary = "查询")
    @GetMapping("/{id}")
    public ResultVO<FriendLink> findById(@PathVariable("id") Integer id) {
        return new ResultVO<>(ResultVOEnum.SUCCESS, friendLinkService.findById(id).orElse(null));
    }

    @Operation(summary = "查询全部")
    @GetMapping("/all")
    public ResultVO<List<FriendLink>> findAll() {
        return new ResultVO<>(ResultVOEnum.SUCCESS, friendLinkService.findAll());
    }

    @Operation(summary = "删除")
    @DeleteMapping("/{id}")
    public ResultVO<Integer> delete(@PathVariable("id") Integer id) {
        friendLinkService.deleteById(id);
        return new ResultVO<>(ResultVOEnum.SUCCESS, id);
    }

    @Operation(summary = "修改")
    @PutMapping("/modify")
    public ResultVO<FriendLink> delete(@RequestBody FriendLink friendLink) {
        return new ResultVO<>(ResultVOEnum.SUCCESS, friendLinkService.save(friendLink));
    }

    @Operation(summary = "添加")
    @PostMapping("/add")
    public ResultVO<FriendLink> add(@RequestBody FriendLink friendLink) {
        return new ResultVO<>(ResultVOEnum.SUCCESS, friendLinkService.save(friendLink));
    }
}