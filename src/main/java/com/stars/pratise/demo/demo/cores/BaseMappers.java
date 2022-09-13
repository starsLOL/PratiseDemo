package com.stars.pratise.demo.demo.cores;


import java.io.Serializable;
import java.util.List;

import com.stars.pratise.demo.core.model.PageInfos;
import org.apache.ibatis.annotations.Param;


/**
 * 通用Mapper
 *
 * @param <T>  实体
 * @param <PK> 主键
 */
public interface BaseMappers<T, PK extends Serializable> {

    /**
     * 查询（根据主键ID查询）
     **/
    T selectByPrimaryKey(@Param("id") Long id);

    /**
     * 删除（根据主键ID删除）
     **/
    int deleteByPrimaryKey(@Param("id") Long id);

    /**
     * 添加
     **/
    int insert(T entity);

    /**
     * 添加 （匹配有值的字段）
     **/
    int insertSelective(T entity);

    /**
     * 修改 （匹配有值的字段）
     **/
    int updateByPrimaryKeySelective(T entity);

    /**
     * 修改（根据主键ID修改）
     **/
    int updateByPrimaryKey(T entity);

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    List<T> selectListByCondition(PageInfos page);

    int selectCountByCondition(PageInfos page);
}

