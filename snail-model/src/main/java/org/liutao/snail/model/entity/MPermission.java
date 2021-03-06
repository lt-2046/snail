package org.liutao.snail.model.entity;


import org.liutao.snail.model.base.MysqlLongIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "M_PERMISSION")
public class MPermission extends MysqlLongIdEntity {

    @Column(name = "permission_name")
    private String permissionName;
    @Column(name = "url")
    private String url;
    @Column(name = "parent_id")
    private Long parentId;
    @Column(name = "start")
    private Long start;
    @Column(name = "mark")
    private String mark;
    @Column(name = "version")
    private String version;
    @Column(name = "order_num")
    private Long orderNum;

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "MPermission{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                ", url='" + url + '\'' +
                ", parentId=" + parentId +
                ", start=" + start +
                ", mark='" + mark + '\'' +
                ", version='" + version + '\'' +
                ", orderNum=" + orderNum +
                '}';
    }
}
