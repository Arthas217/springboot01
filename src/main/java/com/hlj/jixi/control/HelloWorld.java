package com.hlj.jixi.control;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    // 选取配置文件application.yml 且访问http://localhost:8081/hello
    @RequestMapping("/hello")
    public String hello(){
        return "Hello world";
    }

    @Value("${person.last-name}")
    private String name;
    // 选取配置文件person.properties 且访问http://localhost:8082/hello2
    @RequestMapping("/hello2")
    public String hello2(){
        return "Hello world" + name;
    }

}
