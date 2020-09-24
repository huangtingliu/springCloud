package com.huangtl.gateway.config;

/**
 * Sentinel 提供了 Spring Cloud Gateway 的适配模块（似乎没什么用，加了反而会重复过滤）
 * @Description https://github.com/alibaba/Sentinel/wiki/%E7%BD%91%E5%85%B3%E9%99%90%E6%B5%81#spring-cloud-gateway
 * @Author huangtl
 * @Date 2020/9/23 15:57
 **/
/*@Configuration
public class SentinelConfig {
    private final List<ViewResolver> viewResolvers;
    private final ServerCodecConfigurer serverCodecConfigurer;

    public SentinelConfig(ObjectProvider<List<ViewResolver>> viewResolversProvider,
                          ServerCodecConfigurer serverCodecConfigurer) {
        this.viewResolvers = viewResolversProvider.getIfAvailable(Collections::emptyList);
        this.serverCodecConfigurer = serverCodecConfigurer;
    }

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SentinelGatewayBlockExceptionHandler sentinelGatewayBlockExceptionHandler() {
        // Register the block exception handler for Spring Cloud Gateway.
        return new SentinelGatewayBlockExceptionHandler(viewResolvers, serverCodecConfigurer);
    }

    *//**
     * 框架已经自带了sentinelGatewayFilter过滤器了，重复注入会报错，修改名称可以注入，但是如果本处再注入一个，会发生两倍限流
     * @return
     *//*
    *//*@Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public GlobalFilter sentinelGatewayFilter() {
        System.out.println("sentinelGatewayFilter1");
        return new SentinelGatewayFilter();
    }*//*
}*/
