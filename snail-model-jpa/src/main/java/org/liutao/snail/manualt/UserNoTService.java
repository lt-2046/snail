package org.liutao.snail.manualt;

import org.liutao.snail.base.BaseService;
import org.liutao.snail.exception.RFPGppBizException;
import org.liutao.snail.model.entity.MRole;
import org.liutao.snail.model.entity.MUser;
import org.liutao.snail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutao on 2019/4/10.
 */
@Service("userNoTService")
//@Transactional(propagation= Propagation.NOT_SUPPORTED)
public class UserNoTService extends BaseService{
    @Autowired
    private UserService userService;
    @Autowired
    private TransactionTemplate transactionTemplate;

    public void save(MUser user) throws RFPGppBizException {
        int j = 0;
        List<TransactionStatus> statusList = new ArrayList<TransactionStatus>();
        for (int i = 0; i < 10; i++) {
            TransactionDefinition td = new DefaultTransactionDefinition();

            PlatformTransactionManager manager = transactionTemplate.getTransactionManager();
            TransactionStatus status = manager.getTransaction(td);
            System.out.println("是否是新事务 " + status.isNewTransaction());
            try {
                statusList.add(status);
                if (i == 6) {
                    j = j + 1;
                    manager.rollback(status);
                    continue;
                }
                MUser userT = new MUser();
                if (i == 7) {
                    userT.setPhone("012345678901234567890123456789");
                }
//                userService.save(userT);
//                if (i == 7) {
//                    userT.setPhone("01234567890");
//                    userT.setAliasName("7");
//                }
                userService.save(userT);

                MRole r = new MRole();
                if(i == 8){
                    r.setRoleName("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
                }else{
                    r.setRoleName("test");
                }
                roleService.saveRole(r);

                manager.commit(status);
            } catch (Exception e) {
                j = j + 1;
                // 这部是关键
//                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//                status.setRollbackOnly();
                manager.rollback(status);
                e.printStackTrace();
            }

        }

        for(TransactionStatus s : statusList){
            System.out.println("事务是否完成" + s.isCompleted());
        }
        if(j>0){
            throw new RFPGppBizException();
        }

    }
}