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

    @Test
    public void testPerson() {
        System.out.println(person);
    }


    @Autowired
    ApplicationContext context;

    @Test
    public void testService(){
        boolean helloservice = context.containsBean("helloService");
        System.out.println(helloservice);
    }


    @Test
    public void testLog(){
        Logger logger = LoggerFactory.getLogger(getClass());
        //日志级别  级别由低到高
        logger.trace("这是trace");
        logger.debug("这是debug");
        logger.info("这是info");
        logger.warn("这是warn");
        logger.error("这是error");
    }

}
