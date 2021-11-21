package top.youngwind.blog.controller.user;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import top.youngwind.blog.entity.user.RoleEntity;
import top.youngwind.blog.entity.user.UserEntity;
import top.youngwind.blog.service.user.PermissionService;
import top.youngwind.blog.service.user.RoleService;
import top.youngwind.blog.service.user.UserService;
import top.youngwind.blog.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户管理")
@CrossOrigin
@RestController
@RequestMapping("/admin/user")
public class UserController {
    private UserService userService;
    private RoleService roleService;
    private PermissionService permissionService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @Operation(summary = "查询所有用户")
    @GetMapping("/all")
    public ResultVO<List<UserEntity>> findAllUsers() {
        return new ResultVO<List<UserEntity>>()
                .setData(userService.findAll())
                .setCode(200)
                .setMessage("查询成功");
    }

    @Operation(summary = "通过Id删除用户")
    @DeleteMapping("/{id}")
    public ResultVO<Integer> deleteUserById(@ApiParam("用户Id") @PathVariable("id") Integer id) {
        userService.deleteById(id);
        return new ResultVO<Integer>()
                .setData(id)
                .setCode(200)
                .setMessage("删除成功");
    }

    @Operation(summary = "添加用户")
    @PostMapping("/add")
    public ResultVO<UserEntity> addUser(@RequestBody UserEntity userEntity) {
        UserEntity user = userService.add(userEntity.getUsername(), userEntity.getPassword());
        return new ResultVO<UserEntity>()
                .setData(user)
                .setCode(200)
                .setMessage("添加成功");
    }

    @Operation(summary = "修改用户信息")
    @PutMapping("/modify")
    public ResultVO<UserEntity> modifyUser(@ApiParam("用户对象") @RequestBody UserEntity userEntity) {
        userService.save(userEntity);
        return new ResultVO<UserEntity>()
                .setData(userEntity)
                .setCode(200)
                .setMessage("修改成功");
    }

    @Operation(summary = "为用户赋予角色的权限")
    @PutMapping("/grant")
    public ResultVO<UserEntity> authorizationForUser(@ApiParam("用户Id") @RequestParam("userId") Integer userId,
                                                     @ApiParam("角色Id") @RequestParam("roleId") Integer roleId) {
        UserEntity user = userService.findById(userId);
        RoleEntity role = roleService.findById(roleId);
        user.setRole(role);
        UserEntity savedUser = userService.save(user);

        return new ResultVO<UserEntity>()
                .setData(savedUser)
                .setCode(200)
                .setMessage("授权成功");
    }
}
