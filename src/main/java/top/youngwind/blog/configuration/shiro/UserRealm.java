package top.youngwind.blog.configuration.shiro;

import top.youngwind.blog.entity.user.PermissionEntity;
import top.youngwind.blog.entity.user.RoleEntity;
import top.youngwind.blog.entity.user.UserEntity;
import top.youngwind.blog.service.user.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }
    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        // 1. 从主体中传过来的认证信息中，获得用户唯一Id
        String username = principalCollection.getPrimaryPrincipal().toString();

        // 2. 根据用户名获得密码
        UserEntity user = userService.findByUsername(username);

        /**
         *  3. 创建授权信息
         *    3.1 创建授权对象
         *    3.2 创建角色对象
         */
        SimpleAuthorizationInfo simpleAuthorizationInfo  = new SimpleAuthorizationInfo();
        RoleEntity roleBean = user.getRole();

        // 3.3 添加角色
        simpleAuthorizationInfo.addRole(roleBean.getRoleName());

        // 3.4 添加权限
        Set<PermissionEntity> permissions = roleBean.getPermissions();
        for (PermissionEntity permission : permissions) {
            simpleAuthorizationInfo.addStringPermission(permission.getPermissionsName());
        }

        return simpleAuthorizationInfo;

    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 1. 从主体中传过来的认证信息中，获得用户唯一Id
        UsernamePasswordToken passwordToken= (UsernamePasswordToken) authenticationToken;
        String username = passwordToken.getPrincipal().toString();

        // 2. 根据用户名获得密码
        UserEntity userBean = userService.findByUsername(username);
        if (userBean == null) {
            //这里返回后会报出对应异常
            throw new UnknownAccountException();
        }

        String password = userBean.getPassword();
        // 3. 自定义盐值,配置文件中配置
        ByteSource salt = ByteSource.Util.bytes("mshd");

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                username,
                password,
                salt,
                getName());

        return authenticationInfo;

    }
}
