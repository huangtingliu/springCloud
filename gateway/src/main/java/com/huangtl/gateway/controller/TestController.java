package com.huangtl.gateway.controller;

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
        return "这是网关服务";
    }

}
