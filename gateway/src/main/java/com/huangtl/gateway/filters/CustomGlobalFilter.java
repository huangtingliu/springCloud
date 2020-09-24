package com.huangtl.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义GlobalFilter写法1
 * @Description 写法2跳转 {@link com.huangtl.gateway.config.FilterConfig}
 * @Author huangtl
 * @Date 2020/9/22 9:57
 **/
@Component
public class CustomGlobalFilter implements GlobalFilter, Ordered {

    /**
     * 若有匹配路由，会执行本方法再去请求下游接口，否则不执行
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("custom global filter");
        exchange.getRequest().mutate().header("CUSTOM-REQUEST-HEADER", "自定义header").build();
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}
