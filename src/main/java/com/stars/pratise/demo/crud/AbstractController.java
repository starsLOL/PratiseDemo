package com.stars.pratise.demo.crud;

import com.stars.pratise.demo.common.ResponseData;

import java.util.Map;

/**
 * @Author stars
 * @Description 声明泛型基类
 */
public abstract class AbstractController<T, K> {

    /**
     * 新增
     *
     * @param t
     * @return
     */
    public abstract ResponseData insert(T t);

    /**
     * 修改
     *
     * @param t
     * @return
     */
    public abstract ResponseData update(T t);

    /**
     * 删除
     *
     * @param
     * @return
     */
    public abstract ResponseData delete(K id);

    /**
     * 按主键查询
     *
     * @param
     * @return
     */
    public abstract ResponseData get(K Id);

    /**
     * 查询全部结果
     *
     * @param
     * @return
     */
    public abstract ResponseData selectAll();


    /**
     * 分页查询
     *
     * @return
     */
    public abstract ResponseData queryPageList(int pageSize, int pageIndex, Map<String, Object> params);

    /**
     * 多条件查询
     *
     * @return
     */
    public abstract ResponseData queryList(Map<String, Object> params);
}

