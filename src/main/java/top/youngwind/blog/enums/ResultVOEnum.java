package top.youngwind.blog.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultVOEnum {
    FAILURE(0,"失败"),
    SUCCESS(1,"成功");

    private Integer code;
    private String message;
}
