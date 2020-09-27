package com.huangtl.openfeign.controller;

import com.huangtl.openfeign.service.OrderService;
import com.huangtl.openfeign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description TODO
 * @Author huangtl
 * @Date 2020/9/27 14:08
 **/
@RestController
public class HelloController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/hello")
    public String hello(){
        return userService.sayHello();
    }

    @RequestMapping("/orders")
    @ResponseBody
    public List<String> orders(){
        return orderService.getOrders();
    }
}
