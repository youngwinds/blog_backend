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
@ApiModel("博客文章")
public class Article {
    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", introduce='" + introduce + '\'' +
                ", content='" + content + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", coverInfo='" + coverInfo + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }

    @ApiModelProperty("Id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; // Id

    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("作者")
    private String author;
    @ApiModelProperty("介绍")
    private String introduce;
    @ApiModelProperty("内容")
    private String content;
    @ApiModelProperty("封面url")
    private String coverUrl;
    @ApiModelProperty("封面说明")
    private String coverInfo;

    @ApiModelProperty("分类Id")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @ApiModelProperty("创建时间")
    @CreatedDate
    private Date createAt;
    @ApiModelProperty("更新时间")
    @LastModifiedDate
    private Date updateAt;

}
