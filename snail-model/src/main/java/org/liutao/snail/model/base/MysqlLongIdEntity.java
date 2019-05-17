package org.liutao.snail.model.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Mysql数据库的主键生成定义:系统生成自增长整数型数据作为主键
 *
 * @author Jeff Xu
 * @since 2015-12-09
 */
@MappedSuperclass
public abstract class MysqlLongIdEntity extends IdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}