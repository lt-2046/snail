package org.liutao.snail.model.hibernate.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.liutao.snail.core.model.GeneralDao;
import org.liutao.snail.core.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by liutao on 2019/4/17.
 */
@Repository
public class HibernateBaseDao<T extends Serializable> extends HibernateDaoSupport implements GeneralDao<T> {
    Logger logger = LogManager.getLogger(HibernateBaseDao.class.getName());

    @Autowired
    @Qualifier("sessionFactory")
    public void initSupperSessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }


    public Page<T> findListBySQL(Page<T> page, Class clazz) {
        return null;
    }

    public List<T> findListBySQL(String sql, List<String> params, Class clazz) {
        return null;
    }

    public Page<T> findMapBySQL(Page<T> page) {
        return null;
    }

    public List<Map> findMaptBySQL(String sql, List<String> params) {
        return null;
    }

    public void saveByBatch(List<T> list) {

    }

    public void updateByBatch(List<T> list) {

    }
}