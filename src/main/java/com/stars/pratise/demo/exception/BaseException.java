package com.stars.pratise.demo.exception;

/**
 * 基础异常类
 *
 * @author stars
 * @version 1.0
 * @date 2022-09-10
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 3130573143041496768L;
    /**
     * 错误编码
     */
    protected String code;

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
