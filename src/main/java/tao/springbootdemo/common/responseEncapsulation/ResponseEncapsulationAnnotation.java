package tao.springbootdemo.common.responseEncapsulation;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * @Author: Tao
 * @Time: 2020/12/13 14:18
 * @ProjectName：spring-boot-demo
 * @FileName: ResponsePackage.java
 * @IDE: IntelliJ IDEA
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@RestController
public @interface ResponseEncapsulationAnnotation {
}
