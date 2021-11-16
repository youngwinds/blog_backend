package top.youngwind.blog.controller.user;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import top.youngwind.blog.entity.user.PermissionEntity;
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


@Api(tags = "权限管理")
@RestController
@RequestMapping("/admin/permission")
public class PermissionController {
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

    @Operation(summary = "查询全部权限")
    @GetMapping("/ALL")
    public ResultVO<List<PermissionEntity>> findAllPermissions() {
        return new ResultVO<List<PermissionEntity>>()
                .setData(permissionService.findAll())
                .setCode(200)
                .setMessage("查询成功");
    }

    @RequiresPermissions("添加")
    @Operation(summary = "添加权限")
    @PostMapping("/add")
    public ResultVO<PermissionEntity> addPermission(@ApiParam("权限名称") @RequestParam("name") String name) {
        PermissionEntity permissionEntity = new PermissionEntity();
        permissionEntity.setPermissionsName(name);
        PermissionEntity savedPermission = permissionService.save(permissionEntity);

        return new ResultVO<PermissionEntity>()
                .setData(savedPermission)
                .setCode(200)
                .setMessage("新增成功");
    }

    @RequiresPermissions("删除")
    @Operation(summary = "删除权限")
    @DeleteMapping("/{id}")
    public ResultVO<String> deletePermission(@ApiParam("权限名称") @PathVariable("id") Integer id) {
        permissionService.deleteById(id);

        return new ResultVO<String>()
                .setData("删除成功")
                .setCode(200)
                .setMessage("删除成功");
    }

    @RequiresPermissions("修改")
    @Operation(summary = "修改权限")
    @PutMapping("/modify")
    public ResultVO<String> deletePermission(@ApiParam("权限对象") @RequestBody PermissionEntity permissionEntity) {
        permissionService.save(permissionEntity);

        return new ResultVO<String>()
                .setData("修改成功")
                .setCode(200)
                .setMessage("修改成功");
    }
}
