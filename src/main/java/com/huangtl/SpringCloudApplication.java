package com.huangtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * created by htl on 2017/7/14.
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringCloudApplication {

    public static void main(String[] args)throws Exception{
        SpringApplication.run(SpringCloudApplication.class,args);
    }
}
