package com.huangtl.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description eureka服务启动类
 * @Author huangtl
 * @Date 2020/9/1 15:30
 **/
@SpringBootApplication
@EnableFeignClients
public class OpenFeignApp {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApp.class, args);
    }
}
