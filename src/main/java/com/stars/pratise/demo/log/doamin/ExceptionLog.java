package com.stars.pratise.demo.log.doamin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionLog implements Serializable {
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
    // 异常名称
    private String exceptionName;
    // 异常信息
    private String exceptionMessage;
    // 类方法
    private String classMethod;
    // 请求参数
    private Object requestParams;
    // 接口耗时
    private Long timeCost;
    // 操作系统
    private String os;
    // 浏览器
    private String browser;
    // user-agent
    private String userAgent;

}
