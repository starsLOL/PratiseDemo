package com.stars.pratise.demo.crud;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface IServices<T, K> {
    /**
     * 新增
     *
     * @param t
     * @return
     */
    public Object insert(T t);

    /**
     * 修改
     *
     * @param t
     * @return
     */
    public Object update(T t);

    /**
     * 删除
     *
     * @param
     * @return
     */
    public Object delete(K id);

    /**
     * 按主键查询
     *
     * @param
     * @return
     */
    public T get(K id);

    /**
     * 分页查询
     *
     * @param pageSize
     * @param pageIndex
     * @param params
     * @return
     */
    Object queryPageList(int pageSize, int pageIndex, Map<String, Object> params);

    /**
     * 条件查询
     *
     * @param params
     * @return
     */
    Object queryList(Map<String, Object> params);
}
