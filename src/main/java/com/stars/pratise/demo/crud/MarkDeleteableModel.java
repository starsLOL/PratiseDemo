package com.stars.pratise.demo.crud;

import com.stars.pratise.demo.constants.Constants;
import lombok.Data;
import lombok.EqualsAndHashCode;
//import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


/**
 * 需要标记删除的实体继承该类
 *
 * @author yangwk
 */
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public abstract class MarkDeleteableModel<ID extends Serializable> extends AbstractBaseModel<ID> {


    private static final long serialVersionUID = 1293523350932105207L;
    //    @ApiModelProperty(value="标记删除字段 0未删除 1已删除 ")
    @Column(name = "is_deleted", columnDefinition = "tinyint default 0")
    private Integer isDeleted = Constants.Flag.NO;


}

