package org.liutao.snail.service;

import org.liutao.snail.base.BaseService;
import org.liutao.snail.exception.RFPGppBizException;
import org.liutao.snail.model.jpa.dao.MUserDao;
import org.liutao.snail.model.entity.MRole;
import org.liutao.snail.model.entity.MUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liutao on 2019/4/10.
 */

@Service("userService")
public class UserService extends BaseService {
    @Autowired
    private MUserDao mUserDao;

    public void save(MUser user) throws RFPGppBizException {
        for (int i = 0; i < 5; i++) {
            try {
                MUser userT = new MUser();
                if (i == 2) {
                    userT.setUserName("test_liutao");
                    userT.setPhone("userTuserTuserTuserTuserTuserTuserTuserT");
                } else {
                    userT.setUserName("test_liutao");
                }
                mUserDao.save(userT);

                MRole r = new MRole();
                if (i == 3) {
                    r.setRoleName("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
                } else {
                    r.setRoleName("test");
                }
                roleService.saveRole(r);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void saveNo(MUser user) throws RFPGppBizException {
        try {
            mUserDao.save(user);
        } catch (Exception e) {
            throw new RFPGppBizException();
        }
    }

    private void saveHave() throws RFPGppBizException {
        for (int i = 0; i < 5; i++) {
            try {
                MUser userT = new MUser();
                if (i == 2) {
                    userT.setUserName("test_liutao");
                    userT.setPhone("userTuserTuserTuserTuserTuserTuserTuserT");
                } else {
                    userT.setUserName("test_liutao");
                }
                mUserDao.save(userT);

                MRole r = new MRole();
                if (i == 3) {
                    r.setRoleName("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
                } else {
                    r.setRoleName("test");
                }
                roleService.saveRole(r);
            } catch (Exception e) {
                e.printStackTrace();
//                throw new RFPGppBizException();
            }
        }
    }
}