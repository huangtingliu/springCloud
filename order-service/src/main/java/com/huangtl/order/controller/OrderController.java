package com.huangtl.order.controller;

import cn.hutool.json.JSONObject;
import com.huangtl.order.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author huangtl
 * @Date 2020/9/1 17:02
 **/
@RestController
@Slf4j
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

    @Autowired
    private RedisService redisService;

    //设置redis值
    @RequestMapping("/redis/set/{name}/{value}")
    public String setRedis(@PathVariable(value = "name") String name,@PathVariable(value = "value") String value){
        redisService.set(name,value);
        return "ok";
    }

    @RequestMapping("/redis/get/{name}")
    public String getRedis(@PathVariable(value = "name") String name){
        return redisService.get(name);
    }

    @RequestMapping("/session")
    public String session(HttpSession session){
        System.out.println(session.getId());
        return session.getId();
    }

    @RequestMapping("/sentry")
    public String sentry(){
        log.info("测试sentry打印info日志");
        log.debug("测试sentry打印debug日志");
        log.warn("测试sentry打印warn日志");
        log.trace("测试sentry打印trace日志");
        log.error("测试sentry打印error日志");
        return "ok";
    }

}
