package top.youngwind.blog.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id; // Id

    private String title; // 标题
    private String author; // 作者
    private String introduce; // 介绍
    private String content; // 内容
    private String coverUrl; // 封面 url
    private String coverInfo; // 封面 说明


    @CreatedDate
    private Date createAt;
    @LastModifiedDate
    private Date updateAt;

}
