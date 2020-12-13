package tao.springbootdemo.common.responseEncapsulation;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @Author: Tao
 * @Time: 2020/12/7 11:03
 * @ProjectName：spring-boot-demo
 * @FileName: ResultStatusCode.java
 * @IDE: IntelliJ IDEA
 */
@Getter
public enum ResponseStatusCode {

    /**
     * Http状态码
     */
    SUCCESS(HttpStatus.OK, 200, "OK"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, 401, "Unauthorized"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, 400, "Bad Request"),
    FORBIDDEN(HttpStatus.FORBIDDEN, 403, "Forbidden"),
    NOT_FOUND(HttpStatus.NOT_FOUND, 404, "Not Found"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "Internal Server Error"),
    ;

    /**
     * 业务异常码
     */
    private final Integer code;
    /**
     * 业务异常信息描述
     */
    private final String message;
    private final HttpStatus httpStatus;


    ResponseStatusCode(HttpStatus httpStatus, Integer code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
