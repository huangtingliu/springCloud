package com.huangtl.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author huangtl
 * @Date 2020/10/13 14:17
 **/
@RestController
@RequestMapping("/")
public class TestController {

    @RequestMapping("/")
    public String hello(){
        return "welcome";
    }

    @RequestMapping("/login")
    public String login(){
        return "login page";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "logout page";
    }
}
