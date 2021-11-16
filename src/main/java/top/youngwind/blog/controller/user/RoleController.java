package top.youngwind.blog.controller.user;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import top.youngwind.blog.entity.user.PermissionEntity;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/role")
public class RoleController {
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

    @Operation(summary = "查询所有角色")
    @GetMapping("/all")
    public ResultVO<List<RoleEntity>> findAllRoles() {
        return new ResultVO<List<RoleEntity>>()
                .setData(roleService.findAll())
                .setCode(200)
                .setMessage("查询成功");
    }

    @Operation(summary = "查询角色的全部权限")
    @GetMapping("/findPermissions/{id}")
    public ResultVO<Set<PermissionEntity>> findAllPermissionsByRole(@ApiParam("角色Id") @PathVariable("id") Integer id) {
        RoleEntity role = roleService.findById(id);
        Set<PermissionEntity> permissions = role.getPermissions();

        return new ResultVO<Set<PermissionEntity>>()
                .setCode(200)
                .setMessage("查询成功")
                .setData(permissions);
    }

    @Operation(summary = "查询角色的全部用户")
    @GetMapping("/findUsers/{id}")
    public ResultVO<Set<UserEntity>> findAllUsersByRole(@ApiParam("角色Id") @PathVariable("id") Integer id) {
        RoleEntity role = roleService.findById(id);
        Set<UserEntity> users = role.getUsers();

        return new ResultVO<Set<UserEntity>>()
                .setCode(200)
                .setMessage("查询成功")
                .setData(users);
    }

    @RequiresPermissions("添加")
    @Operation(summary = "添加角色")
    @PostMapping("/add")
    public ResultVO<RoleEntity> addRole(@ApiParam("角色名称") @RequestParam("name") String name) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleName(name);
        RoleEntity savedRole = roleService.save(roleEntity);
        return new ResultVO<RoleEntity>()
                .setCode(200)
                .setMessage("新增成功")
                .setData(savedRole);
    }

    @RequiresPermissions("删除")
    @Operation(summary = "通过Id删除角色")
    @DeleteMapping("/{id}")
    public ResultVO<Integer> deleteRoleById(@ApiParam("角色Id") @PathVariable("id") Integer id) {
        roleService.deleteById(id);
        return new ResultVO<Integer>()
                .setData(id)
                .setCode(200)
                .setMessage("删除该角色成功，并且已删除对应的所有用户信息。");
    }

    @RequiresPermissions("修改")
    @Operation(summary = "修改角色信息")
    @PutMapping("/modify")
    public ResultVO<RoleEntity> modifyRole(@ApiParam("角色对象") @RequestBody RoleEntity roleEntity) {
        roleService.save(roleEntity);
        return new ResultVO<RoleEntity>()
                .setData(roleEntity)
                .setCode(200)
                .setMessage("修改成功");
    }

    @RequiresPermissions("添加")
    @Operation(summary = "为角色授权")
    @PutMapping("/grant")
    public ResultVO<RoleEntity> authorizationForRole(@ApiParam("角色Id") @RequestParam("roleId") Integer roleId,
                                                     @ApiParam("权限Id数组") @RequestBody List<Integer> idsList) {
        RoleEntity role = roleService.findById(roleId);

        List<PermissionEntity> permissionsList = permissionService.findAllByIdIn(idsList);

        HashSet<PermissionEntity> permissions = new HashSet<PermissionEntity>(permissionsList);

        role.setPermissions(permissions);

        roleService.save(role);
        return new ResultVO<RoleEntity>()
                .setData(role)
                .setMessage("授权成功")
                .setCode(200);
    }
}
