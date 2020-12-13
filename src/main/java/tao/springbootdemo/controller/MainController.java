package tao.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tao.springbootdemo.common.responseEncapsulation.ResponseEncapsulationAnnotation;

import java.util.Map;

/**
 * @Author: Tao
 * @Time: 2020/12/13 15:24
 * @ProjectName：spring-boot-demo
 * @FileName: MainController.java
 * @IDE: IntelliJ IDEA
 */
@Slf4j
@ResponseEncapsulationAnnotation
@RequestMapping("")
public class MainController {
    @GetMapping("get")
    public String getMapping(@RequestParam String id) {
        return "get";
    }

    @PostMapping("post")
    public Map<String, String> postMapping(@RequestBody Map<String, String> map) {
        Map<String, String> stringStringMap = Map.of("123", "456");
        log.info(stringStringMap.getClass().toString());
        return stringStringMap;
    }
}
