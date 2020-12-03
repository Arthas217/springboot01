package com.hlj.jixi.config;

import com.hlj.jixi.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * springboot推荐全注解方式 给容器中添加组件
 */
@Configuration
public class HelloServiceConfig {

    @Bean
    public HelloService helloService01(){
        System.out.println("配置类 注解方式给容器添加组件");
        return new HelloService();
    }
}
