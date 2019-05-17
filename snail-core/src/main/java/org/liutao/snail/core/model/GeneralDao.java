package org.liutao.snail.core.model;

/**
 * Created by liutao on 2019/4/1.
 */

import org.liutao.snail.core.page.Page;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * 通用Dao接口定义，主要用于面向接口编程，定义通用接口方法
 * 提供自定义实现的原生SQL支持
 */
public interface GeneralDao<T> {

    /**
     * 分页查询返回Page对象中结构集为List
     *
     * @param page
     * @return
     */
    public Page<T> findListBySQL(Page<T> page, Class clazz);

    /**
     * 不分页查询，使用原生sql查询，返回List类型对象
     *
     * @param sql
     * @param params 参数
     * @param clazz  返回对象类型
     * @return
     */
    public List<T> findListBySQL(String sql, List<String> params, Class clazz);

    /**
     * 分页查询返回Page对象中结构集为List中包含Map对象
     *
     * @param page
     * @return
     */
    public Page<T> findMapBySQL(Page<T> page);

    /**
     * 分页查询，使用原生sql查询，返回Map类型对象
     *
     * @param sql
     * @param params
     * @return
     */
    public List<Map> findMaptBySQL(String sql, List<String> params);

    /**
     * 接口定义的default方法，返回当前泛型的class
     *
     * @return
     */
    default Class<T> getTypeClass(){
        try {
            return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }catch (Exception e){
            new Exception("初始化失败，继承BaseMybatisDao，没有泛型！",e);
        }
        return null;
    }

    /**
     * 批量保存
     * @param list
     */
    public void saveByBatch(List<T> list);

    /**
     * 批量更新
     * @param list
     */
    public void updateByBatch(List<T> list);
}
