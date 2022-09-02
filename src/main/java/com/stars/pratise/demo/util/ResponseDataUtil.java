package com.stars.pratise.demo.util;

import com.stars.pratise.demo.common.ResponseData;
import com.stars.pratise.demo.entity.User;
import com.stars.pratise.demo.enums.ResultEnums;

import java.util.List;

public class ResponseDataUtil<T> {
    /**
     * 带实体的统一返回
     *
     * @param <T>  实体类型
     * @param data 实体
     * @return 定义返回JSON格式
     */
    public static <T> ResponseData success(T data) {
        return ResponseData.success(data);
    }

//    public static ResponseData buildSuccess(String msg) {
//        return new ResponseData(ResultEnums.SUCCESS.getCode(), msg);
//    }

    public static <T> ResponseData buildSuccess(int code, String msg) {
        return new ResponseData<T>(code, msg);
    }

    public static <T> ResponseData buildSuccess(int code, String msg, T data) {
        return new ResponseData<T>(code, msg, data,System.currentTimeMillis());
    }

    public static <T> ResponseData buildSuccess(ResultEnums resultEnums) {
        return new ResponseData<T>(resultEnums);
    }

    public static <T> ResponseData buildError(T data) {
        return new ResponseData<T>(ResultEnums.ERROR, data);
    }

    public static <T> ResponseData buildError() {
        return new ResponseData<T>(ResultEnums.ERROR);
    }

//    public static ResponseData buildError(String msg) {
//        return new ResponseData(ResultEnums.ERROR.getCode(), msg);
//    }

    public static <T> ResponseData buildError(int code, String msg) {
        return new ResponseData<T>(code, msg);
    }

    public static <T> ResponseData buildError(int code, String msg, T data) {
        return new ResponseData<T>(code, msg, data,System.currentTimeMillis());
    }

    public static <T> ResponseData buildError(ResultEnums resultEnums) {
        return new ResponseData<T>(resultEnums);
    }

    /** 业务异常返回业务代码,描述和返回的参数 */
    public static <T> ResponseData failure() {
        return new ResponseData<T>(ResultEnums.INTERNAL_SERVER_ERROR, null);
    }


}
