package tao.springbootdemo.common.exceptionHandler;

import lombok.Getter;
import tao.springbootdemo.common.responseEncapsulation.ResponseStatusCode;

/**
 * @Author: Tao
 * @Time: 2020/12/13 14:58
 * @ProjectName：spring-boot-demo
 * @FileName: ResponseException.java
 * @IDE: IntelliJ IDEA
 */
@Getter
public class ResponseException extends Exception {
    private ResponseStatusCode responseStatusCode;

    public ResponseException() {
        this(ResponseStatusCode.INTERNAL_SERVER_ERROR);
    }

    private ResponseException(ResponseStatusCode responseStatusCode) {
        super(responseStatusCode.getMessage());
        this.responseStatusCode = responseStatusCode;
    }
}
