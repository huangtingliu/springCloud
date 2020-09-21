package com.huangtl.gateway.config;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @Description TODO
 * @Author huangtl
 * @Date 2020/9/21 10:43
 **/
@Configuration
public class ExchangeConfig {

//    @Autowired
//    private ServerWebExchange serverWebExchange;
//
//    @Bean
//    public ServerWebExchange exchange(){
//        return ServerWebExchangeDecorator.;
//    }
//
    @PostConstruct
    public void init(){
        System.out.println("init............");
//        System.out.println(serverWebExchange.getAttributes());
//        Object attribute = serverWebExchange.getAttribute(ServerWebExchangeUtils.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
//        System.out.println(attribute);
    }
}
