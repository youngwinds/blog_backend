package top.youngwind.blog.entity;

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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; // Id

    private String title; // 标题
    private String author; // 作者
    private String introduce; // 介绍
    private String content; // 内容
    private String coverUrl; // 封面 url
    private String coverInfo; // 封面 说明

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @CreatedDate
    private Date createAt;
    @LastModifiedDate
    private Date updateAt;

}
