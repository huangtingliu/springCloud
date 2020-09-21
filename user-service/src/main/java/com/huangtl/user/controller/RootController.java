package com.huangtl.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Description TODO
 * @Author huangtl
 * @Date 2020/9/1 17:02
 **/
@RestController
public class RootController {

    @RequestMapping("/")
    public String hello(){
        return "这是用户服务";
    }

    @RequestMapping("/a")
    public String a(HttpServletRequest request){
        System.out.println("打印请求头");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            try {
                System.out.println(headerNames.nextElement() + ":" + request.getHeader(headerNames.nextElement()));
            }catch (Exception e){}
        }
        return "这是用户a服务";
    }

    @RequestMapping("/b")
    public String b(HttpServletRequest request){
        System.out.println("打印请求参数");
        System.out.println(request.getParameter("name"));
        return "这是用户b服务";
    }

    @RequestMapping("/red/a")
    public String reda(){
        return "这是用户/red/a服务";
    }
}
