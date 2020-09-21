package com.huangtl.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

/**
 * @Description TODO
 * @Author huangtl
 * @Date 2020/9/21 20:19
 **/
@Configuration
public class RouteConfig {

    //替换请求体路由，要用post请求
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        //postman post请求http://localhost:8091/create 测试
        return builder.routes()
                .route("rewrite_request_obj", r -> r.path("/create")
                        .filters(f -> f.prefixPath("/rewrite-body")
                                .modifyRequestBody(String.class, NewBody.class, MediaType.APPLICATION_JSON_VALUE,
                                        (exchange, s) -> {return Mono.just(new NewBody(s.toUpperCase()));}))
                        .uri("lb://ORDER-SERVICE")).build();
    }

    static class NewBody {
        String message;

        public NewBody() { }

        public NewBody(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
