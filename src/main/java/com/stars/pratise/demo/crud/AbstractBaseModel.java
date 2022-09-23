package com.stars.pratise.demo.crud;

//import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 提取了部分公共字段，可以避免多个实体重复设置这些属性
 *
 * @author yangwk
 * @version v1.0
 * @time 2017年8月9日 下午1:50:22
 */
@MappedSuperclass
@Data
public abstract class AbstractBaseModel<ID extends Serializable> implements BaseModel<ID> {

    private static final long serialVersionUID = -4557195346494355256L;

    //    @ApiModelProperty(value = "创建者ID")
    @Column(columnDefinition = "Long default 0")
    private Long creator = 0L;

    //    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Timestamp createTime;

    //    @ApiModelProperty(value = "最后修改人")
    @Column(columnDefinition = "Long default 0")
    private Long updater = 0L;

    //    @ApiModelProperty(value = "最后修改时间")
    @Column(name = "update_time")
    private Timestamp updateTime;

}
