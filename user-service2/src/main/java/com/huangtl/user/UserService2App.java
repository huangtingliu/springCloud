package com.huangtl.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description eureka服务启动类
 * @Author huangtl
 * @Date 2020/9/1 15:30
 **/
@SpringBootApplication
@EnableEurekaClient
public class UserService2App {

    public static void main(String[] args) {
        SpringApplication.run(UserService2App.class, args);
    }
}
