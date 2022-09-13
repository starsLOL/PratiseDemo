package com.stars.pratise.demo.common.restResult;

import com.stars.pratise.demo.enums.ResultEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor //创建一个无参构造函数
@AllArgsConstructor //创建一个全参构造函数
public class ResponseData<T> implements Serializable {

//    如果是ResponseInfo<T>，那么泛型怎么指定，<T> ResponseInfo<T>这样返回可以更好的指定泛型


    /**
     * response code, 200 -> OK.
     */
    private int code;

    private String message;

    private T result;

    /**
     * response timestamp.
     */
    private long timestamp;


    public ResponseData(int code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public ResponseData(ResultEnums resultEnums) {
        this.code = resultEnums.getCode();
        this.message = resultEnums.getMessage();
        this.timestamp = System.currentTimeMillis();
    }

    public ResponseData(ResultEnums resultEnums, T result) {
        this.code = resultEnums.getCode();
        this.message = resultEnums.getMessage();
        this.result = result;
        this.timestamp = System.currentTimeMillis();
    }


    /**
     * response success result wrapper.
     *
     * @param <T> type of data class
     * @return response result
     */
    public static <T> ResponseData<T> success() {
        return ResponseData.<T>builder()
                .message(ResultEnums.SUCCESS.getMessage())
                .code(ResultEnums.SUCCESS.getCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * response success result wrapper.
     *
     * @param data response data
     * @param <T>  type of data class
     * @return response result
     */
    public static <T> ResponseData<T> success(T data) {
        return ResponseData.<T>builder().result(data)
                .message(ResultEnums.SUCCESS.getMessage())
                .code(ResultEnums.SUCCESS.getCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }


    /**
     * response error result wrapper.
     *
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T extends Serializable> ResponseData<T> fail(String message) {
        return fail(400, message);
    }

    /**
     * response error result wrapper.
     *
     * @param code    response data
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T> ResponseData<T> fail(int code, String message) {
        return ResponseData.<T>builder()
                .message(message)
                .code(code)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * response error result wrapper.
     *
     * @param resultEnums ResultEnums resultEnums
     * @param <T>         type of data class
     * @return response result
     */
    public static <T> ResponseData<T> fail(ResultEnums resultEnums) {
        return ResponseData.<T>builder()
                .message(resultEnums.getMessage())
                .code(resultEnums.getCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }


    /**
     * response error result wrapper.
     *
     * @param code message    set code and msg
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
//    public static <T> ResponseData<T> fail(int code, String message) {
//        ResponseData<T> resultData = new ResponseData<T>();
//        resultData.setCode(String.valueOf(code));
//        resultData.setMessage(message);
//        return resultData;
//    }


}

