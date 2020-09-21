package com.huangtl.eureka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author huangtl
 * @Date 2020/9/1 17:02
 **/
@RestController
public class TestController {

    @RequestMapping("/")
    public String hello(){
        return "这是第一个eureka注册中心";
    }
}
