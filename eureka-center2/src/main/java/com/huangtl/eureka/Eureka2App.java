package com.huangtl.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description eureka服务启动类
 * @Author huangtl
 * @Date 2020/9/1 15:30
 **/
@SpringBootApplication
@EnableEurekaServer
public class Eureka2App {

    public static void main(String[] args) {
        SpringApplication.run(Eureka2App.class, args);
    }
}
