package top.youngwind.blog.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class PermissionEntity {
    public PermissionEntity() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String permissionsName;

    /**
     * 多对多关系：
     * 一个角色对应多个权限
     * 一个权限对应多个角色
     */
    @JsonIgnore
    @ManyToMany(mappedBy = "permissions",cascade = CascadeType.ALL)
    private Set<RoleEntity> roles = new HashSet<>();

    @CreatedDate
    private Date createTime;
    @LastModifiedDate
    private Date updateTime;

}
