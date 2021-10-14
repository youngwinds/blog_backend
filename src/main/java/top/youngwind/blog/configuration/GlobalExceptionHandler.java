package top.youngwind.blog.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.youngwind.blog.enums.ResultVOEnum;
import top.youngwind.blog.vo.ResultVO;

@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO<String> sendErrorResponse_System(Exception exception) {
        return new ResultVO<>(ResultVOEnum.FAILURE, exception.getCause().getCause().getMessage());
    }
}
