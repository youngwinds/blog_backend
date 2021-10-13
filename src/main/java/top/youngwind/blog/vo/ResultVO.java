package top.youngwind.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import top.youngwind.blog.enums.ResultVOEnum;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "请求结果标准对象")
public class ResultVO<T> {

    @ApiModelProperty("消息")
    private String message;
    @ApiModelProperty("状态")
    private Integer code;
    @ApiModelProperty("数据")
    private T data;

    public ResultVO(ResultVOEnum resultVOEnum, T data) {
        this.setMessage(resultVOEnum.getMessage());
        this.setCode(resultVOEnum.getCode());
        this.setData(data);
    }
}
