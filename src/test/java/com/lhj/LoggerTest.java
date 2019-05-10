package com.lhj;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: sell
 * @description: logger(日志测试)类
 * @author: lhj
 * @create: 2019-04-07 01:27
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
//使用@Slf4j注解就不用再写LoggerFactory.getLogger()方法了
@Slf4j
//@Data
public class LoggerTest {
    //在LoggerFactory.getLogger()方法中写哪个类就打印哪个类的日志  一定要注意写当前类
//    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1(){
//        logger.debug("debug...");
//        logger.info("info....");
//        logger.error("error...");
        log.debug("debug...");
        log.info("info....");
        log.error("error...");
    }

    //在日志中输出变量
    @Test
    public void test2(){
        String name = "lhj";
        String password = "123456";
        //{}表示一个占位符 里面写什么都可以
        log.info("name: {},password: {}", name, password);
    }
}
