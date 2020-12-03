package com.hlj.jixi;

import com.hlj.jixi.bean.Person;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01ApplicationTests {

    @Autowired
    Person person;

    /**
     * 测试通过配置文件读取对象person值
     */
    @Test
    public void testPerson() {
        System.out.println(person);
    }


    @Autowired
    ApplicationContext context;

    /**
     * 测试向容器添加helloService组件
     */
    @Test
    public void testService(){
        // 默认过去方法的名称作为 id= helloService
        boolean helloservice = context.containsBean("helloService");
        boolean helloservice01 = context.containsBean("helloService01");
        System.out.println(helloservice);
        System.out.println(helloservice01);
    }

    //
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testLog(){
        // 日志级别由低到高
        logger.trace("这是trace---------------------------------");
        logger.debug("这是debug---------------------------------");
        // spring 默认级别
        logger.info("这是info---------------------------------");
        logger.warn("这是warn---------------------------------");
        logger.error("这是error---------------------------------");
    }

}
