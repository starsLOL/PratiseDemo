package com.stars.pratise.demo.constants;

import com.google.common.base.Charsets;

import java.nio.charset.Charset;

/**
 * 系统级常量类
 *
 * @author stars
 * @version 1.0
 */
public class Constants {

    public static final String APP_NAME = "stars";

    /**
     * 系统编码
     */
    public static final Charset CHARSET = Charsets.UTF_8;


    /**
     * 系统编码
     */
    public static final String pageNum = "1";


    /**
     * 系统编码
     */
    public static final String pageSize = "10";


    /**
     * 普通用户
     */
    public static final String ROLE_CODE_USER = "user";
    /**
     * 操作员
     */
    public static final String ROLE_CODE_OPERATOR = "operator";
    /**
     * 管理员
     */
    public static final String ROLE_CODE_ADMIN = "admin";


    /**
     * 标识：是/否、启用/禁用等
     */
    public interface Flag {

        /**
         * 已删除
         */
        Integer YES = 1;

        /**
         * 未删除
         */
        Integer NO = 0;

    }

    /**
     * 操作类型
     */
    public interface Operation {
        /**
         * 添加
         */
        String ADD = "add";
        /**
         * 更新
         */
        String UPDATE = "update";
        /**
         * 删除
         */
        String DELETE = "delete";
        /**
         * 查询
         */
        String SELECT = "select";
    }

    /**
     * 性别
     */
    public interface Sex {
        /**
         * 男
         */
        Integer MALE = 1;
        /**
         * 女
         */
        Integer FEMALE = 0;
    }
}
