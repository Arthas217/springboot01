package com.hlj.jixi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


// 一种方式 通过xml+@ImportResource（导入spring的配置文件）方式 向容器中添加组件（不是很好方式）
// 另一种springboot推荐全注解方式 给容器中添加组件（参考配置类HelloServiceConfig）
@ImportResource(locations = "classpath:beans.xml")
@SpringBootApplication
public class Springboot01Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01Application.class, args);
    }

}
