package com.stars.pratise.demo.crud;

import com.github.pagehelper.Page;
import tk.mybatis.mapper.common.*;

import java.util.List;
import java.util.Map;

//1. BaseMapper(因为tk.mapper是不能被springboot扫描到的，所以不能放在springboot扫描mapper的包下，不然会报错)
//@org.apache.ibatis.annotations.Mapper
public interface Mappers<T> extends Mapper<T>, MySqlMapper<T> {

//    int deleteByPrimaryKey(K id);

//    int insert(T record);

//    int insertSelective(T record);

//    T selectByPrimaryKey(K id);

//    int updateByPrimaryKeySelective(T record);

//    int updateByPrimaryKey(T record);

    /**
     * 分页查询（由子类实现）
     *
     * @param params
     * @return
     */
    Page queryPageList(Map<String, Object> params);

    /**
     * 多条件查询（由子类实现）
     *
     * @param params
     * @return
     */
    List<Map<String, Object>> queryList(Map<String, Object> params);
}