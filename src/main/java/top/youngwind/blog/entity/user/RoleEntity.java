package top.youngwind.blog.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
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
public class RoleEntity {
    public RoleEntity() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String roleName;

    /**
     * 多对多关系：
     * 一个角色对应多个权限
     * 一个权限对应多个角色
     */
    @JsonIgnore
    @ManyToMany(targetEntity = PermissionEntity.class,fetch = FetchType.EAGER)
    @JoinTable(name = "u_role_permission",
            //当前对象在中间表中的外键
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            //对方对象在中间表中的外键
            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")}
    )
    private Set<PermissionEntity> permissions = new HashSet<>();

    /**
     * 一对多关系：一个角色对应多个用户
     */
    @JsonIgnore
    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    private Set<UserEntity> users = new HashSet<>();

    @CreatedDate
    private Date createTime;
    @LastModifiedDate
    private Date updateTime;

}
