package org.liutao.snail.model.entity;


import org.liutao.snail.model.base.MysqlLongIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "M_USER_ROLE")
public class MUserRole extends MysqlLongIdEntity {

    @Column(name = "u_id")
    private Long uId;
    @Column(name = "r_id")
    private Long rId;
    @Column(name = "start")
    private Long start;

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "MUserRole{" +
                "id=" + id +
                ", uId=" + uId +
                ", rId=" + rId +
                ", start=" + start +
                '}';
    }
}
