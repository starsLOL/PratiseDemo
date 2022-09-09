package com.stars.pratise.demo.exception;

/**
 * Service层异常
 *
 * @author stars
 * @version 1.0
 * @date 2022-09-10
 */
public class ServiceException extends BaseException {

    private static final long serialVersionUID = 4658103132015220281L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String code, String message) {
        super(code, message);
    }

}
