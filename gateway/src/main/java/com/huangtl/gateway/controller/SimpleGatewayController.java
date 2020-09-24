package com.huangtl.gateway.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 使用Spring MVC方式或Webflux方式在接口方法修改参数ProxyExchange实现简单网关
 * 需引入spring-cloud-gateway-mvc依赖（注意mvc需要spring-boot-starter-web包，而gateway不兼容spring-boot-starter-web）
 * 官方文档https://docs.spring.io/spring-cloud-gateway/docs/2.2.4.RELEASE/reference/html/#building-a-simple-gateway-by-using-spring-mvc-or-webflux
 * @Author huangtl
 * @Date 2020/9/1 17:02
 **/
@RestController
public class SimpleGatewayController {
/*
    *//**
     * 使用Spring MVC方式
     * @param proxy
     * @return
     * @throws Exception
     *//*
    @GetMapping("/springmvc-proxy")
    public ResponseEntity<?> proxyMvc(ProxyExchange<byte[]> proxy) throws Exception {
        return proxy.uri("http://localhost:8091" + "/red/a").get();
    }

    *//**
     * Webflux方式
     * @param proxy
     * @return
     * @throws Exception
     *//*
    @GetMapping("/Webflux-proxy")
    public Mono<ResponseEntity<?>> proxyWebflux(ProxyExchange<byte[]> proxy) throws Exception {
        return Mono.just(proxy.uri("http://localhost:8091" + "/red/a").get());
    }

    *//**
     * 提取尾部路径
     * @param proxy
     * @return
     * @throws Exception
     *//*
    @GetMapping("/proxy/path/**")
    public ResponseEntity<?> proxyPath(ProxyExchange<byte[]> proxy) throws Exception {
        String path = proxy.path("/proxy/path/");
        return proxy.uri("http://localhost:8091" + path).get();
    }*/
}
