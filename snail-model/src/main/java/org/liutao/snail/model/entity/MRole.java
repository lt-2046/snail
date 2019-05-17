package org.liutao.snail.model.entity;

import org.liutao.snail.model.base.MysqlLongIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "M_ROLE")
public class MRole extends MysqlLongIdEntity {


    @Column(name = "role_name")
    private String roleName;
    @Column(name = "start")
    private Long start;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "MRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", start=" + start +
                '}';
    }
}
