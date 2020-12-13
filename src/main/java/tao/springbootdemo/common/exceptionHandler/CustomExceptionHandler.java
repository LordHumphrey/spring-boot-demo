package tao.springbootdemo.common.exceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;
import tao.springbootdemo.common.responseEncapsulation.ResponseEncapsulation;

/**
 * @Author: Tao
 * @Time: 2020/12/13 14:44
 * @ProjectName：spring-boot-demo
 * @FileName: CustomExceptionHandler.java
 * @IDE: IntelliJ IDEA
 */
@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    /**
     * 异常捕获
     *
     * @param ex      异常
     * @param request 请求
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ResponseEncapsulation<?>> exceptionHandler(Exception ex, WebRequest request) {
        log.error("ExceptionHandler: {}", ex.getMessage());
        HttpHeaders headers = new HttpHeaders();
        if (ex instanceof ResponseException) {
            return this.handleResponseException((ResponseException) ex, headers, request);
        }
        //这里可以自定义其他的异常拦截
        return this.handleException(ex, headers, request);
    }


    /**
     * ResponseException自定义异常类的处理
     *
     * @param ex      异常
     * @param headers Http头
     * @param request 请求
     * @return ResponseEntity
     */
    private ResponseEntity<ResponseEncapsulation<?>> handleResponseException(ResponseException ex, HttpHeaders headers, WebRequest request) {
        ResponseEncapsulation<?> body = ResponseEncapsulation.failed(ex.getResponseStatusCode(), ex.getMessage());
        HttpStatus status = ex.getResponseStatusCode().getHttpStatus();
        return this.handleExceptionInternal(ex, body, headers, status, request);
    }


    /**
     * 异常类的统一处理
     *
     * @param ex      异常
     * @param headers Http头
     * @param request 请求
     * @return ResponseEntity
     */
    private ResponseEntity<ResponseEncapsulation<?>> handleException(Exception ex, HttpHeaders headers, WebRequest request) {
        ResponseEncapsulation<?> body = ResponseEncapsulation.failed();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return this.handleExceptionInternal(ex, body, headers, status, request);
    }


    /**
     * 处理http响应
     *
     * @param ex      异常
     * @param body    响应体
     * @param headers Http头
     * @param status  Http状态码
     * @param request 请求
     * @return ResponseEntity
     */
    private ResponseEntity<ResponseEncapsulation<?>> handleExceptionInternal(
            Exception ex, ResponseEncapsulation<?> body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity<>(body, headers, status);
    }
}
