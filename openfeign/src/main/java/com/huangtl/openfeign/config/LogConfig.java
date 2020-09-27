package com.huangtl.openfeign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description feign日志配置
 * 配合application.yml文件使用：
 * logging:
 *   level:
 *     com.huangtl.openfeign.service.OrderService: DEBUG
 * 官方文档：https://docs.spring.io/spring-cloud-openfeign/docs/2.2.5.RELEASE/reference/html/#feign-logging
 * @Author huangtl
 * @Date 2020/9/27 14:05
 **/
@Configuration
public class LogConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
