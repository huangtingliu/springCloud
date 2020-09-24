package com.huangtl.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description eureka服务启动类
 * @Author huangtl
 * @Date 2020/9/1 15:30
 **/
@SpringBootApplication
//@EnableEurekaClient //当使用nacos时注释掉
@EnableDiscoveryClient
public class GateWayApp {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApp.class, args);
    }
}
