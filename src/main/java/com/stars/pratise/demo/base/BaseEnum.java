package com.stars.pratise.demo.base;

/**
 * 基础枚举接口
 *
 * @author stars
 * @version 1.0
 */
public interface BaseEnum<K, V> {

    /**
     * 获取编码
     *
     * @return 编码
     */
    K code();

    /**
     * 获取描述
     *
     * @return 描述
     */
    V desc();

}
