package com.stars.pratise.demo.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stars.pratise.demo.common.ResponseData;
import com.stars.pratise.demo.enums.ResultEnums;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;

/**
 * @author: stars
 * @date 2022/9/1
 * @Description:
 * 避免每个接口都手工制定ResultData返回值
 * 借助SpringBoot提供的ResponseBodyAdvice, controller直接返回数据对象即可,advice自动封装成统一返回对象;
 *  --增加该类后，Knife4j访问报错，通过basePackages可解决，如下：
 *  * swagger相当于是寄宿在应用程序中的一个web服务，统一响应处理器拦截了应用所有的响应，对swagger-ui的响应产生了影响。
 *  * 解决集成Swagger出现404问题，配置统一响应处理器拦截的范围，只拦截本项目的Controller类
 */

//@RestControllerAdvice 拦截Controller方法的返回值, 统一处理返回值/响应体, 一般用于统一返回格式、加解密、签名等等
@RestControllerAdvice(basePackages = "com.stars.pratise.demo.controller")
public class ResponseResultBodyAdvice implements ResponseBodyAdvice<Object> {
    @Autowired
    private ObjectMapper objectMapper;


    /**
     * 判断类或者方法是否使用了 @ResponseResultBody
     */
    // 启用 advice功能 ; 默认false
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }


    /**
     * 当类或者方法使用了 @ResponseResultBody 就会调用这个方法
     */
    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if(o instanceof String){
            return objectMapper.writeValueAsString(ResponseData.success(o));
        }
        // 防止重复包裹的问题出现
        if(o instanceof ResponseData){
            return o;
        }
        return ResponseData.success(o);
    }
}