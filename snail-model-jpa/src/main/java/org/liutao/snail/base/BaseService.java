package org.liutao.snail.base;

import org.liutao.snail.exception.RFPGppBizException;
import org.liutao.snail.model.entity.MUser;
import org.liutao.snail.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liutao on 2019/4/10.
 */
public abstract class BaseService {
    @Autowired
    protected RoleService roleService;
    public abstract void save(MUser user) throws RFPGppBizException;



}