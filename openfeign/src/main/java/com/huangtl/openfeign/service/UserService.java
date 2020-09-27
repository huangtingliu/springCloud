package com.huangtl.openfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description feign客户端
 * @Author huangtl
 * @Date 2020/9/27 14:09
 **/
@FeignClient("user-service")
public interface UserService {

    @GetMapping(path = "/hello")
    String sayHello();
}
