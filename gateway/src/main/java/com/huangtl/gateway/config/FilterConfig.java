package com.huangtl.gateway.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

import java.security.Principal;

/**
 * 自定义全局过滤器写法2
 * @Description 写法1跳转 {@link com.huangtl.gateway.filters.CustomGlobalFilter}
 * 官方文档 https://docs.spring.io/spring-cloud-gateway/docs/2.2.4.RELEASE/reference/html/#writing-custom-global-filters
 * @Author huangtl
 * @Date 2020/9/23 9:49
 **/
@Configuration
public class FilterConfig {

    /**
     * 修改请求参数
     * @return
     */
    @Bean
    public GlobalFilter customGlobalFilter2() {
        return (exchange, chain) -> exchange.getPrincipal()
                .map(Principal::getName)
                .defaultIfEmpty("Default User")
                .map(userName -> {
                    //adds header to proxied request
                    exchange.getRequest().mutate().header("CUSTOM-REQUEST-HEADER", userName).build();
                    return exchange;
                })
                .flatMap(chain::filter);
    }

    /**
     * 修改请求后响应内容
     * @return
     */
    @Bean
    public GlobalFilter customGlobalPostFilter() {
        return (exchange, chain) -> chain.filter(exchange)
                .then(Mono.just(exchange))
                .map(serverWebExchange -> {
                    //adds header to response
                    serverWebExchange.getResponse().getHeaders().set("CUSTOM-RESPONSE-HEADER",
                            HttpStatus.OK.equals(serverWebExchange.getResponse().getStatusCode()) ? "It worked": "It did not work");
                    return serverWebExchange;
                })
                .then();
    }
}
