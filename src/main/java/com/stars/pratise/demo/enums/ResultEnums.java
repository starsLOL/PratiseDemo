package com.stars.pratise.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public enum ResultEnums {

    // 数据操作错误定义
    SUCCESS(200, "成功!"),
    ERROR(400, "请求失败"),

    BODY_NOT_MATCH(400, "请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH(401, "请求的数字签名不匹配!"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVER_BUSY(503, "服务器正忙，请稍后再试!");


//    SUCCESS("200", "请求成功"),
//    ERROR("400", "请求失败");
//    SUCCESS("0000", "请求成功"),
//    ERROR("1111", "请求失败"),
//    SYSTEM_ERROR("1000", "系统异常"),
//    BUSSINESS_ERROR("2001", "业务逻辑错误"),
//    VERIFY_CODE_ERROR("2002", "业务参数错误"),
//    PARAM_ERROR("2002", "业务参数错误");

    public static final List<ResultEnums> HTTP_STATUS_ALL = Collections.unmodifiableList(
            Arrays.asList(SUCCESS,ERROR,BODY_NOT_MATCH, SIGNATURE_NOT_MATCH, NOT_FOUND, INTERNAL_SERVER_ERROR, SERVER_BUSY
            ));


//    SUCCESS("200", "success"),
//    FAIL("500", "failed"),
//
//    HTTP_STATUS_200("200", "ok"),
//    HTTP_STATUS_400("400", "request error"),
//    HTTP_STATUS_401("401", "no authentication"),
//    HTTP_STATUS_403("403", "no authorities"),
//    HTTP_STATUS_500("500", "server error");
    /**
     * 状态码
     */
    private int code;
    /**
     * 发送信息
     */
    private String message;

}
