package com.stars.pratise.demo.handler;

import com.stars.pratise.demo.common.restResult.ResponseData;
import com.stars.pratise.demo.enums.ResultEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.stream.Collectors;



@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {


//    @RestControllerAdvice，RestController的增强类，可用于实现全局异常处理器
//    @ExceptionHandler,统一处理某一类异常，从而减少代码重复率和复杂度，比如要获取自定义异常可以@ExceptionHandler(BusinessException.class)
//3    @ResponseStatus指定客户端收到的http状态码

    /**
     * 默认全局异常处理。
     * @param e the e
     * @return ResultData
     */
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public <T> ResponseData<String> exception(Exception e) {
//        log.error("全局异常信息 ex={}", e.getMessage(), e);
//        return ResponseData.fail(ResultEnums.INTERNAL_SERVER_ERROR.getCode(),e.getMessage());
//    }
    /**
     * 默认全局异常处理。
     * @param e the e
     * @return ResultData
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public <T> ResponseData<String> exception(Exception e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return ResponseData.fail(ResultEnums.INTERNAL_SERVER_ERROR.getCode(),e.getMessage());
    }


    @ExceptionHandler(value = {BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<ResponseData<String>> handleValidatedException(Exception e) {
        ResponseData<String> resp = null;

        if (e instanceof MethodArgumentNotValidException) {
            // BeanValidation exception
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            resp = ResponseData.fail(HttpStatus.BAD_REQUEST.value(),
                    ex.getBindingResult().getAllErrors().stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining("; "))
            );
        } else if (e instanceof ConstraintViolationException) {
            // BeanValidation GET simple param
            ConstraintViolationException ex = (ConstraintViolationException) e;
            resp = ResponseData.fail(HttpStatus.BAD_REQUEST.value(),
                    ex.getConstraintViolations().stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.joining("; "))
            );
        } else if (e instanceof BindException) {
            // BeanValidation GET object param
            BindException ex = (BindException) e;
            resp = ResponseData.fail(HttpStatus.BAD_REQUEST.value(),
                    ex.getAllErrors().stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining("; "))
            );
        }

        log.error("参数校验异常:{}",resp.getMessage());
        return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
    }

}

