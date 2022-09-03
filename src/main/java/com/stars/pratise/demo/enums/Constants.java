package com.stars.pratise.demo.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Constants {
    /**
     * 其它
     */
    OTHER("OTHER", "其他操作"),

    /**
     * 新增
     */
    INSERT("INSERT", "添加"),

    /**
     * 修改
     */
    UPDATE("UPDATE", "更新"),

    /**
     * 删除
     */
    DELETE("DELETE", "删除"),

    /**
     * 查询
     */
    SELECT("SELECT", "查询");

    private String operateType;
    private String describe;

}
