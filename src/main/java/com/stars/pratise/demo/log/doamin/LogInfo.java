package com.stars.pratise.demo.log.doamin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogInfo implements Serializable {
    // 主键id
//    @TableId(type = IdType.ASSIGN_UUID)
    //    private String id;
    // 主键id
    private long id;
    // 线程id
    private String threadId;
    // 线程名称
    private String threadName;
    // ip
    private String ip;
    // url
    private String url;
    // http方法 GET POST PUT DELETE PATCH
    private String httpMethod;
    //http 请求响应状态码
    private Integer httpStatus;
    // 操作模块
    private String operateModul;
    // 操作类型
    private String operateType;
    // 操作描述
    private String operateDesc;
    // 类方法
    private String classMethod;
    // 请求参数
    private Object requestParams;
    // 返回参数
    private Object result;
    // 接口耗时
    private Long timeCost;
    // 操作用户id
    private String userId;
    // 操作用户名称
    private String userName;
    // 操作系统
    private String os;
    // 浏览器
    private String browser;
    // user-agent
    private String userAgent;
    // 版本号
    private String version;
    // 创建时间
    private LocalDateTime createTime;
}
