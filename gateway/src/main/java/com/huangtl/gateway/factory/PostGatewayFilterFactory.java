package com.huangtl.gateway.factory;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

/**
 * 请求后处理自定义过滤器工厂
 * @Description 注意类名需要以 GatewayFilterFactory 结尾
 * @Author huangtl
 * @Date 2020/9/22 13:54
 **/
public class PostGatewayFilterFactory extends AbstractGatewayFilterFactory<PostGatewayFilterFactory.Config> {

    public PostGatewayFilterFactory() {
        super(Config.class);
    }

    /**
     * 过滤处理，可以参考官方的一些过滤器写法 {@link org.springframework.cloud.gateway.filter.factory}
     * @param config
     * @return
     */
    @Override
    public GatewayFilter apply(Config config) {
        // 从配置对象中获取配置
        return (exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                ServerHttpResponse response = exchange.getResponse();
                //处理响应内容
            }));
        };
    }

    public static class Config {
        //将配置属性放在这里
        private String afterContent;

        public String getAfterContent() {
            return afterContent;
        }

        public void setAfterContent(String afterContent) {
            this.afterContent = afterContent;
        }
    }
}
