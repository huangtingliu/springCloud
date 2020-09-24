package com.huangtl.gateway.factory;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 自定义路由匹配表达式
 * @Description 类名以前缀+RoutePredicateFactory的方式，比如MyRoutePredicateFactory，配置里
 * @Author huangtl
 * @Date 2020/9/22 14:56
 **/
@Component
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config> {

    public MyRoutePredicateFactory() {
        super(Config.class);
    }

    /**
     * 可以参考官方自带的一些表达式{@link org.springframework.cloud.gateway.handler.predicate}
     * @param config
     * @return
     */
    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        // grab configuration from Config object
        return exchange -> {
            //根据exchange的一些信息判断是否通过
            ServerHttpRequest request = exchange.getRequest();
            //判断请求参数是否和配置的信息匹配
            if(request.getPath().value().equals(config.getCustomPath())){
                return true;
            }
            return false;
        };
    }

    //需要加此方法apply方法的config才能获取到配置的值，官方文档示例坑爹
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("customPath");
    }

    public static class Config {
        //Put the configuration properties for your filter here
        private String customPath;

        public String getCustomPath() {
            return customPath;
        }

        public void setCustomPath(String customPath) {
            this.customPath = customPath;
        }

        @Override
        public String toString() {
            return customPath;
        }
    }
}
