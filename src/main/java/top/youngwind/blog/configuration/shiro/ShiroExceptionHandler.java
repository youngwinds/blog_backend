package top.youngwind.blog.configuration.shiro;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.youngwind.blog.enums.ResultVOEnum;
import top.youngwind.blog.vo.ResultVO;


@ControllerAdvice
public class ShiroExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    public ResultVO<String> ErrorHandler(AuthorizationException e) {
        return new ResultVO<>(ResultVOEnum.PermissionDenied, "权限不足");
    }
}
