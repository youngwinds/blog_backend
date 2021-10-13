package top.youngwind.blog.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@ApiModel("友情链接")
public class FriendLink {
    @Override
    public String toString() {
        return "FriendLink{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }

    @ApiModelProperty("Id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ApiModelProperty("友情链接名称")
    private String name;
    @ApiModelProperty("友情链接地址")
    private String url;

    @ApiModelProperty("创建时间")
    @CreatedDate
    private Date createAt;
    @ApiModelProperty("更新时间")
    @LastModifiedDate
    private Date updateAt;
}
