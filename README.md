# spring cloud 学习
# version
- spring-cloud Hoxton.SR8
- spring-boot 2.3.3.RELEASE


# spring cloud 子项目
- 注册中心 eureka
- 网关 spring gateway
- 断路器 hystrix、Resilience4J、Sentinel未完成
- 未完待续...


#nacos
项目模块
- nacos-service-provider  （提供服务项目）
- nacos-service-consumer  （调用服务项目）
- gateway (用到sentinel+nacos)
[nacos官方文档](https://github.com/alibaba/spring-cloud-alibaba/blob/master/spring-cloud-alibaba-docs/src/main/asciidoc-zh/nacos-discovery.adoc)

### 步骤
- 启动nacos服务，参考[nacos官网](https://nacos.io/zh-cn/docs/quick-start.html)  
[docker安装](https://nacos.io/zh-cn/docs/quick-start-docker.html)  
网址:http://ip:8848/nacos/  账号：nacos 密码：nacos

- 客户端项目引入依赖
```
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
```
注意：父项目引入
```
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>${spring.cloud.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-alibaba-dependencies</artifactId>
            <version>${spring.cloud.alibaba.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```
- application.properties或者application.yml 配置注册到nacos，[更多配置信息](https://github.com/alibaba/spring-cloud-alibaba/blob/master/spring-cloud-alibaba-docs/src/main/asciidoc-zh/nacos-discovery.adoc#%E5%85%B3%E4%BA%8E-nacos-discovery-starter-%E6%9B%B4%E5%A4%9A%E7%9A%84%E9%85%8D%E7%BD%AE%E9%A1%B9%E4%BF%A1%E6%81%AF)
```
server.port=8081
spring.application.name=nacos-provider
spring.cloud.nacos.discovery.server-addr=127.0.0.1:8848
management.endpoints.web.exposure.include=*
```

#Sentinel相关
#### Sentinel 控制台
- jar包下载：https://github.com/alibaba/Sentinel/releases
- 启动脚本：
```
java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar xxx.jar 
```
- 访问地址和账号密码 http://localhost:8080 账号：sentinel 密码：sentinel
- 配置yml
```
spring:
  cloud:
    sentinel: 
      transport:
        port: 8719
        dashboard: localhost:8080  #启动本项目后需要请求一次才能向sentinel控制台注册
```
#### Spring Cloud Gateway 支持
- [文档](https://github.com/alibaba/spring-cloud-alibaba/blob/master/spring-cloud-alibaba-docs/src/main/asciidoc-zh/sentinel.adoc#spring-cloud-gateway-%E6%94%AF%E6%8C%81)
- 引入依赖
```
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
</dependency>

<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-alibaba-sentinel-gateway</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
```

#### datasource 数据源扩展
- [文档1](https://github.com/alibaba/spring-cloud-alibaba/blob/master/spring-cloud-alibaba-docs/src/main/asciidoc-zh/sentinel.adoc#%E5%8A%A8%E6%80%81%E6%95%B0%E6%8D%AE%E6%BA%90%E6%94%AF%E6%8C%81)
- [文档2](https://github.com/alibaba/Sentinel/wiki/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%99%E6%89%A9%E5%B1%95#datasource-%E6%89%A9%E5%B1%95)
- [nacos配置sentinel规则json各属性](https://github.com/alibaba/Sentinel/wiki/%E5%A6%82%E4%BD%95%E4%BD%BF%E7%94%A8#%E8%A7%84%E5%88%99%E7%9A%84%E7%A7%8D%E7%B1%BB)
实现效果：nacos发布配置后限流效果自动生效
#### OpenFeign 支持
- [文档](https://github.com/alibaba/spring-cloud-alibaba/blob/master/spring-cloud-alibaba-docs/src/main/asciidoc-zh/sentinel.adoc#openfeign-%E6%94%AF%E6%8C%81)

#### RestTemplate 支持 
- [文档](https://github.com/alibaba/spring-cloud-alibaba/blob/master/spring-cloud-alibaba-docs/src/main/asciidoc-zh/sentinel.adoc#resttemplate-%E6%94%AF%E6%8C%81)