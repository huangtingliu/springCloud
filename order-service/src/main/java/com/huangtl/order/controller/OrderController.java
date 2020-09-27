package com.huangtl.order.controller;

import cn.hutool.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author huangtl
 * @Date 2020/9/1 17:02
 **/
@RestController
public class OrderController {

    @RequestMapping("/create")
    public String hello(){
        return "/create：新增了一条订单";
    }

    @RequestMapping("/rewrite-body/create")
    public String orderCreate(@RequestBody JSONObject jsonObject){
        System.out.println(jsonObject);
        return "/rewrite-body/create：新增了一条订单";
    }

    @RequestMapping("/b")
    public String b(HttpServletRequest request){
        return "/b：这是订单b服务";
    }

    @RequestMapping("/orders")
    @ResponseBody
    public List<String> orders(){
        List<String> list = new ArrayList<>();
        list.add("order1");
        list.add("order2");
        list.add("order3");
        return list;
    }
}
