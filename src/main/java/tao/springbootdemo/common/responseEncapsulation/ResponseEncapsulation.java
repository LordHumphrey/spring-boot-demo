package tao.springbootdemo.common.responseEncapsulation;

import lombok.Data;

/**
 * @Author: Tao
 * @Time: 2020/12/13 14:08
 * @ProjectName：spring-boot-demo
 * @FileName: ResultPackage.java
 * @IDE: IntelliJ IDEA
 */
@Data
public class ResponseEncapsulation<T> {
    private Integer code;
    private String message;
    private T data;

    public ResponseEncapsulation() {
    }

    private ResponseEncapsulation(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    static <T> ResponseEncapsulation<T> success(T data) {
        return new ResponseEncapsulation<T>(ResponseStatusCode.SUCCESS.getCode(), ResponseStatusCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> ResponseEncapsulation<T> success(T data, String message) {
        return new ResponseEncapsulation<T>(ResponseStatusCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    private static <T> ResponseEncapsulation<T> failed(ResponseStatusCode errorCode) {
        return new ResponseEncapsulation<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     * @param message   错误信息
     */
    public static <T> ResponseEncapsulation<T> failed(ResponseStatusCode errorCode, String message) {
        return new ResponseEncapsulation<T>(errorCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> ResponseEncapsulation<T> failed(String message) {
        return new ResponseEncapsulation<T>(ResponseStatusCode.BAD_REQUEST.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> ResponseEncapsulation<T> failed() {
        return failed(ResponseStatusCode.BAD_REQUEST);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> ResponseEncapsulation<T> validateFailed() {
        return failed(ResponseStatusCode.BAD_REQUEST);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> ResponseEncapsulation<T> validateFailed(String message) {
        return new ResponseEncapsulation<T>(ResponseStatusCode.BAD_REQUEST.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> ResponseEncapsulation<T> unauthorized(T data) {
        return new ResponseEncapsulation<T>(ResponseStatusCode.UNAUTHORIZED.getCode(), ResponseStatusCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> ResponseEncapsulation<T> forbidden(T data) {
        return new ResponseEncapsulation<T>(ResponseStatusCode.FORBIDDEN.getCode(), ResponseStatusCode.FORBIDDEN.getMessage(), data);
    }
}
