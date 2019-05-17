package org.liutao.snail.model.mybatis.dao;

import org.liutao.snail.model.entity.MPermission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author liutao
 * @date 2018/12/21
 */
@Repository
public interface MPermissionMapper  {
    List<MPermission> selectAllPermission();

}