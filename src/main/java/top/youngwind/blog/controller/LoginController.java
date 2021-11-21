package top.youngwind.blog.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import top.youngwind.blog.entity.user.UserEntity;
import top.youngwind.blog.service.user.UserService;
import top.youngwind.blog.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "登录")
@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "登入")
    @GetMapping("/login")
    public ResultVO<UserEntity> login(@RequestParam("username") String username,
                                   @RequestParam("password") String password) {

        // 获取到当前用户信息
        Subject subject = SecurityUtils.getSubject();
        // 认证得到 token
        UsernamePasswordToken passwordToken = new UsernamePasswordToken(username, password);

        try {
            subject.login(passwordToken);
        } catch (UnknownAccountException e) {
            return new ResultVO<UserEntity>().setCode(400).setMessage("用户名不存在").setData(null);
        } catch (IncorrectCredentialsException e) {
            return new ResultVO<UserEntity>().setCode(400).setMessage("密码错误").setData(null);
        }

        UserEntity user = userService.findByUsername(username);
        return new ResultVO<UserEntity>().setCode(200).setMessage("登陆成功").setData(user);
    }

    @Operation(summary = "登出")
    @GetMapping("/logout")
    public ResultVO<String> login() {
        // 获取到当前用户信息
        Subject subject = SecurityUtils.getSubject();
        // 登出
        subject.logout();
        return new ResultVO<String>().setCode(200).setMessage("登出成功").setData("登出成功");
    }

}
