package org.liutao.snail.service;

import org.liutao.snail.exception.RFPGppBizException;
import org.liutao.snail.model.jpa.dao.MRoleDao;
import org.liutao.snail.model.entity.MRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liutao on 2019/4/15.
 */
@Service
public class RoleService {
    @Autowired
    private MRoleDao mroleDao;

    public void saveRole(MRole role) throws RFPGppBizException {
        try {
            mroleDao.save(role);
        }catch (Exception e){
            throw new RFPGppBizException();
        }

    }
}