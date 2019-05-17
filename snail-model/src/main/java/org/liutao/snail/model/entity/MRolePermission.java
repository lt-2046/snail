package org.liutao.snail.model.entity;


import org.liutao.snail.model.base.MysqlLongIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "M_ROLE_PERMISSION")
public class MRolePermission extends MysqlLongIdEntity {

    @Column(name = "r_id")
    private Long rId;
    @Column(name = "p_id")
    private Long pId;

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        return "MRolePermission{" +
                "id=" + id +
                ", rId=" + rId +
                ", pId=" + pId +
                '}';
    }
}
