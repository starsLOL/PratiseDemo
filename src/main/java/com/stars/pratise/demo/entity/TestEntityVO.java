package com.stars.pratise.demo.entity;

import com.stars.pratise.demo.vaild.EnumString;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


/**
 * @author: Linwei
 * @date 2021/8/12
 * @Description:
 */
@Data
//@ApiModel("测试实体")
public class TestEntityVO {
    private String id;

    @Length(min = 6,max = 12,message = "appId长度必须位于6到12之间")
    private String appId;

    @NotBlank(message = "名字为必填项")
    private String name;

    @NotEmpty(message = "email could not be empty")
    @Email(message = "请填写正确的邮箱地址")
    private String email;

    @EnumString(value = {"F","M"}, message="性别只允许为F或M")
    private String sex;

    @NotEmpty(message = "级别不能为空")
    private String level;
}
