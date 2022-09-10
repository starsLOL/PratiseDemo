package com.stars.pratise.demo.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.stars.pratise.demo.base.BaseDTO;
import com.stars.pratise.demo.util.time.Dates;

import javax.persistence.*;
import java.util.Date;

/**
 * 系统用户
 *
 * @author stars
 * @version 1.0
 * @name User
 */

//① 实体映射
//
//        实体类按照如下规则和数据库表进行转换，注解全部是JPA中的注解：
//
//        表名默认使用类名，驼峰转下划线(只对大写字母进行处理)，如UserInfo默认对应的表名为user_info
//
//        表名可以使@Table(name = "tableName")进行指定，对不符合第一条默认规则的可以通过这种方式指定表名。
//
//        字段默认和@Column一样，都会作为表字段，表字段默认为Java对象的Field名字驼峰转下划线形式。
//
//        可以使用@Column(name = "fieldName")指定不符合第3条规则的字段名。
//
//        使用@Transient注解可以忽略字段，添加该注解的字段不会作为表字段使用，注意，如果没有与表关联，一定要用@Transient标注。
//
//        建议一定是有一个@Id注解作为主键的字段,可以有多个@Id注解的字段作为联合主键。
//
//        默认情况下，实体类中如果不存在包含@Id注解的字段,所有的字段都会作为主键字段进行使用(这种效率极低)。
//
//        由于基本类型，如int作为实体类字段时会有默认值0，而且无法消除，所以实体类中建议不要使用基本类型。


@JsonInclude(JsonInclude.Include.NON_NULL)
//@Table(name = "sys_user")
public class SysUser extends BaseDTO {

    private static final long serialVersionUID = -2151116602931563814L;

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderBy("DESC")
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 生日
     */
    @JsonFormat(pattern = Dates.Pattern.DATE)
    private Date birthday;
    /**
     * 性别：1-男/0-女
     */
    private Integer sex;
    /**
     * 是否启用：1/0
     */
    private Integer enabled;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

}
