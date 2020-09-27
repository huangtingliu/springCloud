package com.huangtl.openfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Description feign客户端
 * @Author huangtl
 * @Date 2020/9/27 14:09
 **/
@FeignClient("order-service")
public interface OrderService {

    @RequestMapping(method = RequestMethod.GET, value = "/orders")
    List<String> getOrders();
}
