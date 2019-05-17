package org.liutao.snail.model.jpa.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.query.NativeQuery;
import org.liutao.snail.core.model.GeneralDao;
import org.liutao.snail.core.page.Page;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by liutao on 2019/4/1.
 */
@Repository
public class JPABaseDao<T extends Serializable> implements GeneralDao<T> {
    Logger logger = LogManager.getLogger(JPABaseDao.class.getName());
    @PersistenceContext
    private EntityManager entityManager;

//    /**
//     * 返回当前泛型的class
//     * @return
//     */
//    private Class<T> getTypeClass(){
//        return (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//    }

    /**
     * 使用原生sql统计查询记录总数
     *
     * @param sql
     * @param params
     * @return
     */
    private int countBySQl(String sql, List<String> params) {
        String countSql = "select count(*) from (" + sql + ") countSql ";

        Query query = entityManager.createNativeQuery(countSql);
        if (params != null) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i + 1, params.get(i));
            }
        }

        return new Integer(query.getSingleResult().toString());
    }


    public Page<T> findListBySQL(Page<T> page, Class clazz){

        int count = countBySQl(page.getSql(), page.getParam());

        Query query = null;
        query = entityManager.createNativeQuery(page.getSql(), clazz);

        List<String> params = page.getParam();
        if (params != null) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i + 1, params.get(i));
            }
        }

        query.setFirstResult(page.getStartNum());
        query.setMaxResults(page.getPageNum());
        List<T> result = query.getResultList();
        page.setResult(result);
        page.setCount(count);

        return page;
    }

    public List<T> findListBySQL(String sql, List<String> params, Class clazz) {
        Query query = entityManager.createNativeQuery(sql, clazz);
        if (params != null) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i + 1, params.get(i));
            }
        }
        return query.getResultList();
    }

    public Page<T> findMapBySQL(Page<T> page) {
        int count = countBySQl(page.getSql(), page.getParam());

        Query query = entityManager.createNativeQuery(page.getSql());
        NativeQuery nativeQuery = query.unwrap(NativeQuery.class);
        nativeQuery.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);

        List<String> params = page.getParam();
        if (params != null) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i + 1, params.get(i));
            }
        }

        nativeQuery.setFirstResult(page.getStartNum());
        nativeQuery.setMaxResults(page.getPageNum());
        List<T> result = nativeQuery.getResultList();

        page.setResult(result);
        page.setCount(count);

        return page;
    }

    public List<Map> findMaptBySQL(String sql, List<String> params) {
        Query query = entityManager.createNativeQuery(sql);

        NativeQuery nativeQuery = query.unwrap(NativeQuery.class);
        if (params != null) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i + 1, params.get(i));
            }
        }
        nativeQuery.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
        return query.getResultList();
    }

    public void saveByBatch(List<T> list) {

    }

    public void updateByBatch(List<T> list) {

    }
}