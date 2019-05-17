package org.liutao.snail.model.jpa.dao;

import org.liutao.snail.model.entity.MUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liutao
 * @date 2018/12/21
 */
public interface MUserDao extends JpaRepository<MUser, Integer> {

}