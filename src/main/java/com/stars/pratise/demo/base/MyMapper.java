package com.stars.pratise.demo.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * DemoBaseMapper
 *
 * @author stars
 * @version 1.0
 * @name BaseMapper
 */

public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}