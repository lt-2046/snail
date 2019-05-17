package org.liutao.snail.model.jpa.dao;

import org.liutao.snail.model.entity.MUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author liutao
 * @date 2018/12/21
 */
public interface MUserRoleDao  extends JpaRepository<MUserRole,Integer> {
}