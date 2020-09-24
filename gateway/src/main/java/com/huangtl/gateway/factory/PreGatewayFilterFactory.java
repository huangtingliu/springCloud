package com.huangtl.gateway.factory;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;

/**
 * 预处理自定义过滤器工厂
 * @Description 注意类名需要以 GatewayFilterFactory 结尾
 * @Author huangtl
 * @Date 2020/9/22 13:54
 **/
public class PreGatewayFilterFactory extends AbstractGatewayFilterFactory<PreGatewayFilterFactory.Config> {

    public PreGatewayFilterFactory() {
        super(Config.class);
    }

    /**
     * 过滤处理，可以参考官方的一些过滤器写法 {@link org.springframework.cloud.gateway.filter.factory}
     * @param config
     * @return
     */
    @Override
    public GatewayFilter apply(Config config) {
        // grab configuration from Config object
        return (exchange, chain) -> {
            //要实现预处理需要在调用chain.filter之前请求做操作
            ServerHttpRequest.Builder builder = exchange.getRequest().mutate();
            //适用 builder处理请求
            return chain.filter(exchange.mutate().request(builder.build()).build());
        };
    }

    public static class Config {
        //将配置属性放在这里
        private String prefix;

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }
    }
}
