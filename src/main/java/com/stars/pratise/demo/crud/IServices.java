package com.stars.pratise.demo.crud;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service
public interface IServices<T, K extends Serializable> {
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
     * 查询全部结果
     * select(null)方法能达到同样的效果
     *
     * @param
     * @return
     */
    public List<T> selectAll();


    /**
     * 分页多条件查询
     * 注：多个条件间是and关系 & 参数是属性对应的类型
     *
     * @param params  {"username:like":"test"} 键的格式为字段名:过滤方式,过滤方式见{@code QueryTypeEnum}
     * @param pageNum pageSize分页信息 new PageRequest(page, size,new Sort(Direction.DESC, "updateTime"))
     * @return
     * @author stars
     */
    Object queryPageList(int pageNum, int pageSize, Map<String, Object> params);

    /**
     * 多条件查询
     * 注：多个条件间是and关系 & 参数是属性对应的类型 使用时注意避免结果集过大
     *
     * @param params {"username:like":"test"} 键的格式为字段名:过滤方式,过滤方式见{@code QueryTypeEnum}
     * @return
     * @author stars
     */
    Object queryList(Map<String, Object> params);
}
