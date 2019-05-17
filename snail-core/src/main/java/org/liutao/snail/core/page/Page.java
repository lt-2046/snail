package org.liutao.snail.core.page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutao on 2019/4/2.
 */
public class Page<T> {

    /**
     * 默认起始记录数
     */
    public static final int DEFAULT_START_NUM = 0;
    /**
     * 默认每页展示的记录数
     */
    public static final int DEFAULT_PAGE_NUM = 20;
    /**
     * 起始记录数
     */
    private int startNum = DEFAULT_START_NUM;
    /**
     * 每页展示的记录数
     */
    private int pageNum = DEFAULT_PAGE_NUM;
    /**
     * 当前页数
     */
    private int thisPageNum = 0;
    /**
     * 总记录数
     */
    private int count;

    /**
     * 总页数
     */
    private int countPage;
    /**
     * 参数
     */
    private List<String> param;

    /**
     * 结果
     */
    public List<T> result = new ArrayList<T>();

    /**
     * 查询语句
     */
    private String sql;

    /**
     *
     * @param startNum 起始记录数
     * @param pageNum  每页展示的记录数
     * @param thisPageNum 当前页数
     * @param param 参数
     * @param sql
     */
    public Page(int startNum, int pageNum, int thisPageNum, String sql,List<String> param ) {
        this.startNum = startNum;
        this.pageNum = pageNum;
        this.thisPageNum = thisPageNum;
        this.param = param;
        this.sql = sql;
    }

    /**
     *
     * @param pageNum  每页展示的记录数
     * @param thisPageNum 当前页数
     * @param param 参数
     * @param sql
     */
    public Page( int pageNum, int thisPageNum, String sql ,List<String> param) {
        this.startNum =pageNum * thisPageNum;
        this.pageNum = pageNum;
        this.thisPageNum = thisPageNum;
        this.param = param;
        this.sql = sql;
    }

    public int getStartNum() {
        return startNum;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getThisPageNum() {
        return thisPageNum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getParam() {
        return param;
    }

    public void setParam(List<String> param) {
        this.param = param;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public int getCountPage() {
        if(count==0){
            return 0;
        }else{
            return count%pageNum==0?count/pageNum:(count/pageNum)+1;
        }
    }
}